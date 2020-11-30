import com.drc.zfgc.contant.PropertiesConstant;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author tengchao.li
 * @description hbase测试类
 * @date 2020/11/3
 */
public class HbaseTest {
    private static final Logger logger = LoggerFactory.getLogger(HbaseTest.class);

    private static Connection con;
    // private Configuration con;
    private static Admin admin;

    static {
        try {
            //获取配置文件
           /* HBaseConfiguration configuration = new HBaseConfiguration();
            configuration.set("","");*/
            //    Configuration configuration = HBaseConfiguration.create();
            //    configuration.set("");
            //      con = ConnectionFactory.createConnection(configuration);

            con = HBaseJdbcConUtil.getCon();
            admin = con.getAdmin();
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            
        }


    }

    // static final String tableName = "zfcg_data";
    //  static final String tableName = "dwd_zfcg_data";
    static final String tableName = PropertiesConstant.HBASE_TABLE_NAME;
    static final String namespace = PropertiesConstant.HBASE_NAME_SPACE;
    static final String columnFamily1 = PropertiesConstant.COLUMN_FAMILY;
    static final String columnFamily2 = "htgg";

    public static void main(String[] args) throws Exception {
        //    scanTable(tableName, "1000", columnFamily1, "url_id");;
        //     dropTable(tableName);
        //    createTable(tableName, columnFamily1, columnFamily2);
        //    scanData(tableName);

       /* Table table = con.getTable(TableName.valueOf(tableName));
        Table table2 = con.getTable(TableName.valueOf(tableName));
        System.out.println(table.equals(table2));*/


        //    getData(tableName, "1000", columnFamily1, "url_id");;
        //    dropNameSpace(namespace);
        //    createTableHaveSplit("cn_zfcg", columnFamily1, columnFamily2);
        //    createTable(tableName, columnFamily1, columnFamily2);
        //   listNameSpace();

//        System.out.println("-----------------------");
//        dropNameSpace(namespace);
//        createNameSpace(namespace);
//        listNameSpace();
//
//        System.out.println("-----------------------");
//        System.out.println(isExistTable(tableName));
//        if (isExistTable(tableName)) {
//            dropTable(tableName);
//            System.out.println(isExistTable(tableName));
//        }
//
        //      createTable(tableName, columnFamily1, columnFamily2);
//        System.out.println(isExistTable(tableName));
//
//        putData(tableName, "1000", columnFamily1, "url_id", "1000");
//
//        listNameSpace();
        close(admin);
    }

    public static Boolean isExistTable(String tableName) throws IOException {
        return admin.tableExists(TableName.valueOf(tableName));

    }

   /* public static Boolean delData(String tableName) throws IOException {

     //   admin.delete

        return admin.tableExists(TableName.valueOf(tableName));
        Table table = con.getTable(tableName);

        Delete delete = new Delete(Bytes.toBytes());
        table.delete();

    }*/


    public static void createTable(String tableName, String... columnFamily) throws IOException {
        // 判断是否存在列族信息
        if (columnFamily.length < 0) {
            logger.error("请创建列族信息..");
            return;
        }
        if (isExistTable(tableName)) {
            logger.error("表已存在");
            return;
        }

        //创建表描述器
//        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

//        tableDescriptor

        //4.循环添加列族信息
        for (String cf : columnFamily) {
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(cf);
//            columnDescriptor.set
            tableDescriptor.addFamily(columnDescriptor);
        }

        admin.createTable(tableDescriptor);
        return;

    }

    //默认6个分区
    public static void createTableHaveSplit(String tableName, String... columnFamily) throws IOException {

        // 判断是否存在列族信息
        if (columnFamily.length < 0) {
            logger.error("请创建列族信息..");
            return;
        }
        if (isExistTable(tableName)) {
            logger.error("表已存在");
            return;
        }

        //创建表描述器
//        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

        HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));

//        tableDescriptor

        //4.循环添加列族信息
        for (String cf : columnFamily) {
            HColumnDescriptor columnDescriptor = new HColumnDescriptor(cf);
//            columnDescriptor.set
            tableDescriptor.addFamily(columnDescriptor);
        }

        byte[][] splitKeys = getSplitKeys();

        admin.createTable(tableDescriptor, splitKeys);
        return;

    }

//    0_15333213637_ 2020-12

    //设置6个分区
    private static byte[][] getSplitKeys() {
        String[] keys = new String[]{"1|", "2|", "3|", "4|", "5|"};
        byte[][] splitKeys = new byte[keys.length][];
        TreeSet<byte[]> rows = new TreeSet<byte[]>(Bytes.BYTES_COMPARATOR);//升序排序
        for (int i = 0; i < keys.length; i++) {
            rows.add(Bytes.toBytes(keys[i]));
        }
        Iterator<byte[]> rowKeyIter = rows.iterator();
        int i = 0;
        while (rowKeyIter.hasNext()) {
            byte[] tempRow = rowKeyIter.next();
            rowKeyIter.remove();
            splitKeys[i] = tempRow;
            i++;
        }
        return splitKeys;
    }


    public static void dropTable(String tableName) throws IOException {
        if (tableName != null) {
            admin.disableTable(TableName.valueOf(tableName));
            admin.deleteTable(TableName.valueOf(tableName));
        }

    }

    public static void dropNameSpace(String namespace) throws IOException {
        if (namespace != null) {
            admin.deleteNamespace(namespace);
        }

    }


    /*
     * @description  创建命名空间
     * @author tengchao.li
     * @date 2020/11/3
     * @param tableName
     * @return void
     */
    public static void createNameSpace(String namespace) throws IOException {
        if (namespace == null) {
            return;
        }
        NamespaceDescriptor.Builder builder = NamespaceDescriptor.create(namespace);

        NamespaceDescriptor nsDesc = builder.build();

        admin.createNamespace(nsDesc);
    }

    public static void listNameSpace() throws IOException {

        NamespaceDescriptor[] namespaceDescriptors = admin.listNamespaceDescriptors();
        System.out.println("----------namespace------------------");
        Arrays.stream(namespaceDescriptors).forEach(ns -> {

            System.out.println(ns.getName());
        });

        System.out.println("----------table_list------------------");
        TableName[] tableNames = admin.listTableNames();


        Arrays.stream(tableNames).forEach(table -> {

            System.out.println(table.getNameAsString() + " ->" + table.getNamespaceAsString());


            try {
                List<HRegionInfo> tableRegions = admin.getTableRegions(table);
                for (HRegionInfo regionInfo : tableRegions) {

                    System.out.println("regionInfo ->" + regionInfo.toString());

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        });

    }

    public static void scanData(String tableName) throws IOException {

        Table table = con.getTable(TableName.valueOf(tableName));

        Scan scan = new Scan();

        //3扫描表
        ResultScanner scanner = table.getScanner(scan);

        for (Result result : scanner) {
            // 解析result
            //    System.out.println(result.listCells().size());
            for (Cell cell : result.listCells()) {


                System.out.println("rowKey\t" + Bytes.toString(CellUtil.cloneRow(cell)) + "\tcolumnFamily:" + Bytes.toString(CellUtil.cloneFamily(cell)) + "\tcolumn:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + "\tvalue:" + Bytes.toString(CellUtil.cloneValue(cell)) + "\ttimestamp:" + cell.getTimestamp());

            }


        }


    }

    public static void getData(String tableName, String rowKey, String columnFamily, String column) throws IOException {

        Table table = con.getTable(TableName.valueOf(tableName));

        Get get = new Get(Bytes.toBytes(rowKey));

        //    Get get1 = new Get();
        //指定列族和列
        get.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));


        Result result = table.get(get);

        if (result != null && !result.isEmpty()) {
            for (Cell cell : result.rawCells()) {

                System.out.println("columnFamily:" + Bytes.toString(CellUtil.cloneFamily(cell)) + "\tcolumn:" + Bytes.toString(CellUtil.cloneQualifier(cell)) + "\tvalue:" + Bytes.toString(CellUtil.cloneValue(cell)) + "\ttimestamp:" + cell.getTimestamp());

              /*  byte[] value = cell.getValue();

                String s2 = Bytes.toString(value);
                System.out.println(s2);

                byte[] bytes = CellUtil.cloneRow(cell);
                String s1 = Bytes.toString(bytes);
                System.out.println(s1);


                byte[] rowArray = cell.getRowArray();

                String s = Bytes.toString(rowArray);
                System.out.println(s);

                System.out.println(cell.toString());*/
                //    cell.get

            }
        }


        Cell[] cells = result.rawCells();


    }


    public static void putData(String tableName, String rowKey, String columnFamily, String column, String value) throws IOException {

        //获取表对象
        Table table = con.getTable(TableName.valueOf(tableName));

        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));

        table.put(put);

        table.close();

    }

    public static void scanTable(String tableName, String rowKey, String columnFamily, String column) throws IOException {

        //获取表对象
        Table table = con.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        ResultScanner scanner = table.getScanner(scan);
        scan.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column));
        while (scanner.iterator().hasNext()) {

            Result next = scanner.next();
            System.out.println(next);
        }

        /*for (; ; ) {


        }*/


    }


    public static void close(Admin admin) throws IOException {
        if (admin != null) {
            admin.close();
        }

    }

}
