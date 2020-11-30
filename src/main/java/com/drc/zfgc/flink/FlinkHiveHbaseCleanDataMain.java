package com.drc.zfgc.flink;

import com.drc.zfgc.contant.PropertiesConstant;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.utils.CleanMethod;
import com.drc.zfgc.utils.ConventUtils;
import com.drc.zfgc.utils.DateUtils;
import lombok.Data;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.SqlDialect;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;


/**
 * @ Description
 * @ Date 2020-11-23 10:22
 * @ Author  husy
 */
public class FlinkHiveHbaseCleanDataMain {


    /*private static String createTableSql = "CREATE TABLE  hive_zfcg.test_hive_1 (\n" +
            "        url_id int ,\n" +
            "        purchaser string  ,\n" +
            "        purchasing_method string ,\n" +
            "        category string ,\n" +
            "        notice string ,\n" +
            "        pub_time string  ,\n" +
            "        region_id string  ,\n" +
            "        region string  ,\n" +
            "        region_1 string  ,\n" +
            "        region_2 string ,\n" +
            "        region_3 string  ,\n" +
            "        url string  ,\n" +
            "        title string  ,\n" +
            "        pro_name string  ,\n" +
            "        agency string ,\n" +
            "        hashcode string ,\n" +
            "        items string  ,\n" +
            "        pro_no string ,\n" +
            "        agency_code string ,\n" +
            "        agency_id int  ,\n" +
            "        supplier string  ,\n" +
            "        supplier_code string  ,\n" +
            "        supplier_id int  ,\n" +
            "        type string  ,\n" +
            "        re_type string  ,\n" +
            "        final_type string  ,\n" +
            "        re_type_status string  ,\n" +
            "        transaction_stage string  ,\n" +
            "        process_type string  ,\n" +
            "        obtain_purchasing_file_addr string  ,\n" +
            "        obtain_purchasing_file_time string  ,\n" +
            "        other1 string ,\n" +
            "        other2 string ,\n" +
            "        other3 string ,\n" +
            "        other4 string ,\n" +
            "        res_file_open_time string  ,\n" +
            "        res_file_open_addr string  ,\n" +
            "        res_file_sub_addr string  ,\n" +
            "        sub_file_dead_time string  ,\n" +
            "        prequalification_time string  ,\n" +
            "        frist_pub_time string  ,\n" +
            "        pro_pub_time string  ,\n" +
            "        obtain_bidding_file_time string  ,\n" +
            "        obtain_bidding_file_addr string  ,\n" +
            "        bidding_file_price string ,\n" +
            "        open_bidding_time string  ,\n" +
            "        open_bidding_addr string  ,\n" +
            "        update_time string  ,\n" +
            "        win_bidding_time string  ,\n" +
            "        expert_name string  ,\n" +
            "        is_ppp tinyint ,\n" +
            "        budget_amount string  ,\n" +
            "        budget_amount_currency string  ,\n" +
            "        budget_amount_unit string  ,\n" +
            "        contract_signing_time string  ,\n" +
            "        win_bidding_total_amount string  ,\n" +
            "        win_bidding_total_amount_unit string  ,\n" +
            "        pro_connect string  ,\n" +
            "        pro_connect_phone string  ,\n" +
            "        purchaser_addr string  ,\n" +
            "        purchaser_phone string  ,\n" +
            "        agency_addr string  ,\n" +
            "        agency_phone string  ,\n" +
            "        win_bidding_supplier string  ,\n" +
            "        win_bidding_supplier_phone string  ,\n" +
            "        win_bidding_supplier_addr string  ,\n" +
            "        summary_content string  ,\n" +
            "        summary_annex string  ,\n" +
            "        text_content string  ,\n" +
            "        text_annex string)";*/

    public static void main(String[] args) {
        System.out.println(DateUtils.formatHhMmSsOfDate(new Date()) + "\t开始执行....");

        String path = "src/main/resources/xml";
        cleanData(path);

    }

    public static void cleanData(String defaultPath) {
        //初始化执行环境
    //    FlinkHiveHbaseCleanDataMain obj = new FlinkHiveHbaseCleanDataMain();
        try {
            System.out.println("进入cleanData方法.....");
            //   EnvironmentSettings fsSettings = null;

            EnvironmentSettings fsSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();

            StreamExecutionEnvironment fsEnv = StreamExecutionEnvironment.getExecutionEnvironment();

            StreamTableEnvironment tEnv = StreamTableEnvironment.create(fsEnv, fsSettings);

            //构建hivecatalog
            String name = "my_hive";
            String defaultDatabase = "default";
            // a local path
            //  String confDir = "D:\\myspace\\flinkdemo\\flinkdemo\\src\\main\\resources";
      /*  String path1 = FlinkHiveHbaseCleanDataMain.class.getClassLoader().getResource("").getPath();
        System.out.println("classpath路径： "+ path1);*/
            //     String homePath = System.getProperty("user.dir");
           /* Class<? extends FlinkHiveHbaseCleanDataMain> aClass = obj.getClass();
            System.out.println(aClass);
            Class<FlinkHiveHbaseCleanDataMain> clzz = FlinkHiveHbaseCleanDataMain.class;
            System.out.println(clzz);
            System.out.println(homePath);
            System.out.println("resource1 : " + clzz.getResource(""));
            System.out.println("resource1 : " + clzz.getResource("../"));
            System.out.println("resource2 : " + clzz.getResource("../../"));
            System.out.println("resource3 : " + clzz.getResource("../../../"));
            System.out.println("resource4 : " + clzz.getResource("../../../../"));
            System.out.println("resource4 : " + clzz.getResource("../../../../../"));
            URL resource = clzz.getResource("../../../../xml");
            System.out.println(resource);
            String path1 = resource.getPath();
            System.out.println(path1);
            String path = path1.replace("/D", "D");
            System.out.println("配置文件路径 :" + path);*/
      /*  System.out.println("当前类加载路径： "+ path);
        String path2 = path.replaceAll("/com/drc/zfgc/flink/", "").replaceAll("\\/","\\");
        System.out.println(path2);*/
            //     String path = "/home/flink/zfcg_conf/xml";

            String confDir = null;

            if (defaultPath != null) {
                confDir = defaultPath;
            } else {
                String homePath = System.getProperty("user.dir");
                confDir = homePath + "/zfcg_conf/xml";
            }
            if (confDir == null) {
                System.err.println("配置文件目录不能为空....");
                return;
            }

            System.out.println("confDir:" + confDir);
            //   String confDir = "src/main/resources/xml";
            //    String version = "3.1.0";
            HiveCatalog hive = new HiveCatalog(name, defaultDatabase, confDir);

            //注册一个catalog并且使用，注意名称要唯一
            String catalogName = "catalog_ltc";
            tEnv.registerCatalog(catalogName, hive);
            tEnv.useCatalog(catalogName);

            //使用hive语法
            tEnv.getConfig().setSqlDialect(SqlDialect.HIVE);

            //查询数据
            String querySql = "select " + PropertiesConstant.QUERY_FIELD + "\tfrom\t" + PropertiesConstant.HIVE_DATABASE + "." + PropertiesConstant.HIVE_TABLE;
            System.out.println("querySql:" + querySql);
            Table table = tEnv.sqlQuery(querySql);
            //执行hivesql的相关操作
            table.printSchema();
            //    table.execute().print();

            //单独字段的处理
            DataStream<HiveData> demo = tEnv.toAppendStream(table, HiveData.class);
            //    DataStream<HiveData3> demo1 = tEnv.toAppendStream(table, HiveData3.class);
            //    System.out.println(demo.toString());

            DataStream<CNGovCleanData> ds = demo.map(new MapFunction<HiveData, CNGovCleanData>() {
                @Override
                public CNGovCleanData map(HiveData value) throws Exception {
                    //修改单独的字段
                    CNGovDataUrl data = new CNGovDataUrl();
                    ConventUtils.hiveData2CNGovDataUrl(value, data);
                    CNGovCleanData cleanData = CleanMethod.clean(data);
                    //   System.out.println(cleanData.getRegion()+"\t"+cleanData.getRegion1()+cleanData.getRegion3());
                    //         System.out.println(cleanData.getItems() + "\t" + cleanData.getRegion1() + cleanData.getRegion3());
                    data = null;
                    return cleanData;
                }
            });
            //插入hbase
            System.out.println("开始插入hbase.....");
            ds.addSink(new HBaseWriter());


      /*  Table t1 = tEnv.fromDataStream(ds);
    //    t1.execute().print();
        tEnv.createTemporaryView("test", t1);
//        tEnv.createTemporaryView("test1",ds);

        // 创建数据库，目前不支持创建hive表
        String dataBaseName = "hive_zfcg";
        String tableName = "test_hive_1";
        String createDbSql = "CREATE DATABASE IF NOT EXISTS  " + dataBaseName;
        tEnv.executeSql(createDbSql);

        tEnv.executeSql("DROP TABLE IF EXISTS hive_zfcg.test_hive_1");

        //创建表
      //  String createTableSql = "create table "+dataBaseName+"."+tableName+"(url_id int, age double)";
    //    String createTableSql = "create table "+dataBaseName+"."+tableName+"(url_id int)";
     //   tEnv.executeSql(createTableSql);
        tEnv.executeSql(createTableSql);
   //     TableResult tr = tEnv.executeSql("insert into  " + dataBaseName + "."+tableName+ " select * from test");
*/
            try {
                fsEnv.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println("异常结束....");
            return;
        }


    }

    @Data
    public static class HiveData implements Serializable {
        private Integer url_id;
        private String category;
        private String category_url;
        private String purchaser;
        private String notice;
        private String pubtime;
        private String region;
        private String title;
        private String agency;
        private String url;
        private String content;
        private String hashcode;

        //    private BaseCalendar.Date put_time;

    }

}

