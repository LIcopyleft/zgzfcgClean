package com.drc.zfgc.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.SqlDialect;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.catalog.hive.HiveCatalog;

import java.io.Serializable;


/**
 * @ Description
 * @ Date 2020-11-23 10:22
 * @ Author  husy
 */
public class FlinkHiveTest {

    public static void main(String[] args) {

        //初始化执行环境
        EnvironmentSettings fsSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamExecutionEnvironment fsEnv = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tEnv = StreamTableEnvironment.create(fsEnv, fsSettings);

        //构建hivecatalog
        String name = "myhive";
        String defaultDatabase = "default";
        // a local path
        //  String hiveConfDir = "D:\\myspace\\flinkdemo\\flinkdemo\\src\\main\\resources";
        String hiveConfDir = "src/main/resources";
        String version = "3.1.0";

        HiveCatalog hive = new HiveCatalog(name, defaultDatabase, hiveConfDir, version);

        //注册一个catalog并且使用，注意名称要唯一
        String catalogName = "myhive_3";
        tEnv.registerCatalog(catalogName, hive);
        tEnv.useCatalog(catalogName);

        //使用hive语法
        tEnv.getConfig().setSqlDialect(SqlDialect.HIVE);

        //查询数据
        // String querySql = "SELECT  i_HiveData_sk,i_current_price FROM  data_1g_par.HiveData";
        //    String querySql = "SELECT  url_id, category, category_url, purchaser, notice, pubtime, region, title, agency, url, content, hashcode, put_time FROM  drcnet_ods.ods_zfcg limit 10";
        String querySql = "SELECT  url_id, category, category_url, purchaser, notice, pubtime, region, title, agency, url, content, hashcode FROM  drcnet_ods.ods_zfcg limit 10";
        //String querySql = "SELECT  *  FROM  drcnet_ods.ods_zfcg limit 10";
        //  String querySql = "SELECT  url_id  FROM  drcnet_ods.ods_zfcg limit 10";
        Table table = tEnv.sqlQuery(querySql);

        //执行hivesql的相关操作
        table.printSchema();
        table.execute().print();

        //单独字段的处理
        //     DataStream<HiveData> demo = tEnv.toAppendStream(table, HiveData.class);
        //     DataStream<Map> demo12 = tEnv.toAppendStream(table, Map.class);

        //   DataStream<Object> mapDataStream = tEnv.toAppendStream(table, Object.class);

      /*  DataStream<HiveData2> demo2 = tEnv.toAppendStream(table, HiveData2.class);
        System.out.println(demo2.toString());*/

        DataStream<HiveData4> demo1 = tEnv.toAppendStream(table, HiveData4.class);
        //    DataStream<HiveData3> demo1 = tEnv.toAppendStream(table, HiveData3.class);
        System.out.println(demo1.toString());





       /* DataStream<HiveData3> demo3 = tEnv.toAppendStream(table, HiveData3.class);
        System.out.println(demo3.toString());*/
        /*DataStream<HiveData> demo = tEnv.toAppendStream(table, HiveData.class);
        DataStream<HiveData> ds = demo.map(new MapFunction<HiveData, HiveData>() {
            @Override
            public HiveData map(HiveData value) throws Exception {
                //修改单独的字段
               *//* Integer o1 = value.getI_HiveData_sk();
                Double o2 = value.getI_current_price();

                o1 = o1 + 1;
                o2 = o2 + 1.1;

                value.setI_HiveData_sk(o1);
                value.setI_current_price(o2);*//*
                return value;
            }
        });


        Table t1 = tEnv.fromDataStream(ds);
        t1.execute().print();
        tEnv.createTemporaryView("test", t1);
//        tEnv.createTemporaryView("test1",ds);

        // 创建数据库，目前不支持创建hive表
        String createDbSql = "CREATE DATABASE IF NOT EXISTS myhive_husy";
        tEnv.executeSql(createDbSql);

        //创建表
        String createTableSql = "create table myhive_husy.test_hive(name int, age double)";
        tEnv.executeSql(createTableSql);
        TableResult tr = tEnv.executeSql("insert into myhive_husy.test_hive select i_HiveData_sk,i_current_price from test");

        try {
            fsEnv.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    public static class HiveData4 implements Serializable {
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
        //    private Date put_time;

        public Integer getUrl_id() {
            return url_id;
        }

        public void setUrl_id(Integer url_id) {
            this.url_id = url_id;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCategory_url() {
            return category_url;
        }

        public void setCategory_url(String category_url) {
            this.category_url = category_url;
        }

        public String getPurchaser() {
            return purchaser;
        }

        public void setPurchaser(String purchaser) {
            this.purchaser = purchaser;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getPubtime() {
            return pubtime;
        }

        public void setPubtime(String pubtime) {
            this.pubtime = pubtime;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAgency() {
            return agency;
        }

        public void setAgency(String agency) {
            this.agency = agency;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashcode() {
            return hashcode;
        }

        public void setHashcode(String hashcode) {
            this.hashcode = hashcode;
        }

       /* public Date getPut_time() {
            return put_time;
        }

        public void setPut_time(Date put_time) {
            this.put_time = put_time;
        }*/
    }

}

