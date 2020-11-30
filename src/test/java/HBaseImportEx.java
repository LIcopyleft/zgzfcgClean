/**
 * @author tengchao.li
 * @description
 * @date 2020/11/4
 */

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HBaseImportEx {
    static Configuration hbaseConfig = null;
    static Connection con = null;
    public static HTablePool pool = null;
    public static String tableName = "test_hbase";

    static {
        //conf = HBaseConfiguration.create();
        //    Configuration HBASE_CONFIG = new Configuration();
        /*HBASE_CONFIG.set("hbase.master", "192.168.230.133:60000");
        HBASE_CONFIG.set("hbase.zookeeper.quorum", "192.168.230.133");
        HBASE_CONFIG.set("hbase.zookeeper.property.clientPort", "2181");*/
        //   hbaseConfig = HBaseConfiguration.create(HBASE_CONFIG);
        hbaseConfig = HBaseConfiguration.create();
        try {
            con = ConnectionFactory.createConnection(hbaseConfig);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool = new HTablePool(hbaseConfig, 1000);
    }

    /*
     * Insert Test single thread
     * */
    public static void SingleThreadInsert() throws IOException {
        System.out.println("---------开始SingleThreadInsert测试----------");
        long start = System.currentTimeMillis();
        //HTableInterface table = null;

        //table = (HTable) pool.getTable(tableName);
        Table table = con.getTable(TableName.valueOf(tableName));

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

    /*
     * 多线程环境下线程插入函数
     *
     * */
    public static void InsertProcess() throws IOException {
        long start = System.currentTimeMillis();
        //HTableInterface table = null;
        HTable table = null;
        table = (HTable) pool.getTable(tableName);
        table.setAutoFlush(false);
        table.setWriteBufferSize(24 * 1024 * 1024);
        //构造测试数据
        List<Put> list = new ArrayList<Put>();
        int count = 10000;
        byte[] buffer = new byte[256];
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            Put put = new Put(String.format("row %d", i).getBytes());
            rand.nextBytes(buffer);
            put.add("f1".getBytes(), null, buffer);
            //wal=false
            put.setWriteToWAL(false);
            list.add(put);
            if (i % 10000 == 0) {
                table.put(list);
                list.clear();
                table.flushCommits();
            }
        }
        long stop = System.currentTimeMillis();
        //System.out.println("WAL="+wal+",autoFlush="+autoFlush+",buffer="+writeBuffer+",count="+count);

        System.out.println("线程:" + Thread.currentThread().getId() + "插入数据：" + count + "共耗时：" + (stop - start) * 1.0 / 1000 + "s");
    }


    /*
     * Mutil thread insert test
     * */
    public static void MultThreadInsert() throws InterruptedException {
        System.out.println("---------开始MultThreadInsert测试----------");
        long start = System.currentTimeMillis();
        int threadNumber = 10;
        Thread[] threads = new Thread[threadNumber];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ImportThread();
            threads[i].start();
        }
        for (int j = 0; j < threads.length; j++) {
            (threads[j]).join();
        }
        long stop = System.currentTimeMillis();

        System.out.println("MultThreadInsert：" + threadNumber * 10000 + "共耗时：" + (stop - start) * 1.0 / 1000 + "s");
        System.out.println("---------结束MultThreadInsert测试----------");
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        int i = "zfcg".hashCode();
        int w = "zbgg".hashCode();
        System.out.println(i + "" + w);

        //SingleThreadInsert();
        //MultThreadInsert();


    }

    public static class ImportThread extends Thread {
        public void HandleThread() {
            //this.TableName = "T_TEST_1";


        }

        //
        public void run() {
            try {
                InsertProcess();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.gc();
            }
        }
    }
}



