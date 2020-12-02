package com.drc.zfgc.utils;

import com.drc.zfgc.contant.PropertiesConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.security.User;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.security.UserGroupInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description hbase测试类
 * @date 2020/11/3
 */
public class HBaseJdbcConUtil {
    private static final Logger logger = LoggerFactory.getLogger(HBaseJdbcConUtil.class);

   /* private static Connection con;
    // private Configuration con;
    private static Admin admin;*/

    public static Connection getCon() {
        try {
            //获取配置文件
           /* HBaseConfiguration configuration = new HBaseConfiguration();
            configuration.set("","");*/
            Configuration configuration = HBaseConfiguration.create();
            configuration.addResource(PropertiesConstant.HBASE_CONFIG_PATH);

            //指定用户名
            UserGroupInformation userGroupInformation = UserGroupInformation.createRemoteUser("hue");
            return ConnectionFactory.createConnection(configuration, User.create(userGroupInformation));
            //    configuration.set("");
            //  return ConnectionFactory.createConnection(configuration);
        } catch (MasterNotRunningException e) {
            e.printStackTrace();
        } catch (ZooKeeperConnectionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   /* static final String tableName = "test_hbase";
    static final String namespace = "ns_zfcg";
    static final String columnFamily1 = "zfcg";
    static final String columnFamily2 = "zbgg";*/

    public static void main(String[] args) throws Exception {
        //    scanTable(tableName, "1000", columnFamily1, "url_id");;
        //    scanData(tableName);
        //    getData(tableName, "1000", columnFamily1, "url_id");;
        //    dropNameSpace(namespace);
        //    createTableHaveSplit("cn_zfcg", columnFamily1, columnFamily2);

        //    listNameSpace();
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
//        createTable(tableName, columnFamily1, columnFamily2);
//        System.out.println(isExistTable(tableName));
//
//        putData(tableName, "1000", columnFamily1, "url_id", "1000");
//
//        listNameSpace();
        //    close(admin);
    }

    public static Boolean isExistTable(Connection con, String tableName) throws IOException {

        Admin admin = con.getAdmin();

        return admin.tableExists(TableName.valueOf(tableName));

    }


    public static void createTable(Connection con, String tableName, String... columnFamily) throws IOException {

        Admin admin = con.getAdmin();
        // 判断是否存在列族信息
        if (columnFamily.length < 0) {
            logger.error("请创建列族信息..");
            return;
        }
        if (isExistTable(con, tableName)) {
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
    }

    //默认6个分区
    public static void createTableHaveSplit(Connection con, String tableName, String... columnFamily) throws IOException {
        Admin admin = con.getAdmin();
        // 判断是否存在列族信息
        if (columnFamily.length < 0) {
            logger.error("请创建列族信息..");
            return;
        }
        if (isExistTable(con, tableName)) {
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


    public static void dropTable(Connection con, String tableName) throws IOException {
        Admin admin = con.getAdmin();
        if (tableName != null) {
            admin.disableTable(TableName.valueOf(tableName));
            admin.deleteTable(TableName.valueOf(tableName));
        }

    }

    public static void dropNameSpace(Connection con, String namespace) throws IOException {
        Admin admin = con.getAdmin();
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
    public static void createNameSpace(Connection con, String namespace) throws IOException {

        Admin admin = con.getAdmin();
        if (namespace == null) {
            return;
        }
        NamespaceDescriptor.Builder builder = NamespaceDescriptor.create(namespace);

        NamespaceDescriptor nsDesc = builder.build();

        admin.createNamespace(nsDesc);
    }

    public static void listNameSpace(Connection con) throws IOException {
        Admin admin = con.getAdmin();
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

    public static void scanData(Connection con, String tableName) throws IOException {

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

    /**
     * 异步往指定表添加数据
     *
     * @param puts      需要添加的数据
     * @param tableName 表名
     * @param finishNum
     * @return long                返回执行时间
     * @throws IOException
     */
    public static long putDataListAsy(Connection conn, String tableName, String columnFamily, List<Map<String, Object>> dataList, AtomicInteger finishNum) throws Exception {
        long currentTime = System.currentTimeMillis();
        final BufferedMutator.ExceptionListener listener = new BufferedMutator.ExceptionListener() {
            @Override
            public void onException(RetriesExhaustedWithDetailsException e, BufferedMutator mutator) {
                for (int i = 0; i < e.getNumExceptions(); i++) {
                    //    System.out.println("Failed to sent put " + e.getRow(i) + ".");
                    logger.error("Failed to sent put " + e.getRow(i) + ".");
                }
            }
        };

        List<Put> puts = new LinkedList<>();
        for (Map<String, Object> map : dataList) {
            //TODO Rowkey 设计方案
            Object urlId = map.get("urlId");
            //    StringUtils
            Put put = new Put(Bytes.toBytes(StringUtil.getRowKey(urlId.toString())));
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next.getValue() != null) {
                    put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(next.getKey()), Bytes.toBytes(next.getValue().toString()));
                }
            }


            puts.add(put);
        }

        BufferedMutatorParams params = new BufferedMutatorParams(TableName.valueOf(tableName)).listener(listener);
        params.writeBufferSize(100 * 1024 * 1024);

        final BufferedMutator mutator = conn.getBufferedMutator(params);
        try {
            mutator.mutate(puts);
            mutator.flush();
            if(finishNum != null){
                finishNum.addAndGet(dataList.size());
                logger.info("finish asy insert\t" + finishNum.toString());
            }

        } finally {
            mutator.close();
        //    closeConnection(conn);
        }

        return System.currentTimeMillis() - currentTime;
    }


    public static void getData(Connection con, String tableName, String rowKey, String columnFamily, String column) throws IOException {

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


    public static void putData(Connection con, String tableName, String rowKey, String columnFamily, String column, String value) throws IOException {

        //获取表对象
        Table table = con.getTable(TableName.valueOf(tableName));

        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));

        table.put(put);

        table.close();

    }

    public static void putDataList(Connection con, String tableName, String columnFamily, List<Map<String, Object>> dataList) throws IOException {


        //获取表对象
        Table table = con.getTable(TableName.valueOf(tableName));
        List<Put> putList = new LinkedList<>();
        for (Map<String, Object> map : dataList) {

            //TODO Rowkey 设计方案

            Object urlId = map.get("urlId");

            //    StringUtils
            Put put = new Put(Bytes.toBytes(StringUtil.getRowKey(urlId.toString())));
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                if (next.getValue() != null) {
                    put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(next.getKey()), Bytes.toBytes(next.getValue().toString()));
                }
            }


            putList.add(put);
        }
        try {
            table.put(putList);
        } finally {
            //table.put(put);
            table.close();
            closeConnection(con);
        }

    }

    public static void scanTable(Connection con, String tableName, String rowKey, String columnFamily, String column) throws IOException {

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

    public static void closeConnection(Connection conn) {

        try {
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

