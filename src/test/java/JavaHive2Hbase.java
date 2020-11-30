import com.drc.zfgc.utils.HBaseJdbcConUtil;
import com.drc.zfgc.utils.HiveJdbcConUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.BufferedMutatorParams;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tengchao.li
 * @description
 * @date 2020/11/5
 */
public class JavaHive2Hbase {

    // private hbaseCon

    private static org.apache.hadoop.hbase.client.Connection hbaseCon = HBaseJdbcConUtil.getCon();

    public static void main(String[] args) {

        Connection hiveCon = HiveJdbcConUtil.getConnnection();


                String sql = "select * from table  where url_id > {begin_id} and url_id < {end_id}";

        PreparedStatement ps = HiveJdbcConUtil.prepare(hiveCon, sql);


    }


    /*
     * Insert Test single thread
     * */
    public static void SingleThreadInsert() throws IOException {
        System.out.println("---------开始SingleThreadInsert测试----------");
        long start = System.currentTimeMillis();
        //HTableInterface table = null;

        String tableName = "";

        //table = (HTable) pool.getTable(tableName);
        Table table = hbaseCon.getTable(TableName.valueOf("tableName"));

        //    table.setAutoFlush(false);

        BufferedMutatorParams params = new BufferedMutatorParams(TableName.valueOf(tableName));
        params.writeBufferSize(24 * 1024 * 1024);
        //    table.setWriteBufferSize(24 * 1024 * 1024);
        //构造测试数据
        List<Put> list = new ArrayList();
        int count = 10;

        for (int i = 1; i <= count; i++) {
            Put put = new Put(Integer.toString(i).getBytes());
            //    rand.nextBytes(buffer);
            put.addColumn(Bytes.toBytes("zfcg"), Bytes.toBytes("url_id"), Bytes.toBytes(Integer.toString(i)));
            put.addColumn(Bytes.toBytes("zfcg"), Bytes.toBytes("content"), Bytes.toBytes("" + i));
            put.addColumn(Bytes.toBytes("zfcg"), Bytes.toBytes("name"), Bytes.toBytes("" + i));

            //    put.add(Bytes.toBytes("zfcg"), Bytes.toBytes("url_id"), buffer);
            //wal=false
            //    put.setWriteToWAL(false);
            list.add(put);
            if (i == count) {
                table.put(list);
                list.clear();
                //    table.
                //  table.flushCommits();
            }
        }
        long stop = System.currentTimeMillis();
        //System.out.println("WAL="+wal+",autoFlush="+autoFlush+",buffer="+writeBuffer+",count="+count);
        table.close();
        System.out.println("插入数据：" + count + "共耗时：" + (stop - start) * 1.0 / 1000 + "s");

        System.out.println("---------结束SingleThreadInsert测试----------");
        HbaseTest.scanData(tableName);
    }


}
