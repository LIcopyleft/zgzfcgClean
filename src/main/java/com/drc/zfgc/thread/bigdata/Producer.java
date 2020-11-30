package com.drc.zfgc.thread.bigdata;

import cn.hutool.core.bean.BeanUtil;
import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.model.TaskQueen;
import com.drc.zfgc.pool.impl.HiveConnectionPool;
import com.drc.zfgc.utils.HiveJdbcConUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/**
 * @author tengchao.li
 * @description 数据生产者, hive查询数据
 * @date 2020/11/11
 */
public class Producer implements Runnable {

    private Vector<String> sqlList;
    private String lock;
    private TaskQueen taskQueen;
    private HiveConnectionPool hivePool;
    private ConfigParam config;


    private static final Logger logger = LoggerFactory.getLogger("Producer");

    //public Producer(){}
    public Producer(HiveConnectionPool hivePool, TaskQueen taskQueen, Vector<String> sqlList, ConfigParam config, String lock) {
        this.sqlList = sqlList;
        this.taskQueen = taskQueen;
        this.hivePool = hivePool;
        this.lock = lock;
        this.config = config;


    }

    // HiveConnectionPool hiveConnPool =


    @Override
    public void run() {
        //   Connection hiveCon = hivePool.getConnection();

        Connection hiveCon = HiveJdbcConUtil.getConnnection();
        //阈值为 查询步长两倍
        final int num = config.getQuerySize() * 2;
        //   List<Map<String, String>> hiveDataMap = getHiveDataMap(hiveCon);
        //    taskQueen.produce(hiveDataMap);

        try {
            synchronized (lock) {
                //   Producer producer = new Producer()
                for (int i = 0; i < sqlList.size(); i++) {
                    //    System.out.println("生产者生产：" + i);
                    logger.info("生产者生产数据开始...");
                    List<Map<String, String>> hiveDataMap = getHiveDataMap(hiveCon, sqlList.get(i));
                    taskQueen.produce(hiveDataMap);
                    logger.info("生产者生产数据结束..." + hiveDataMap.size() + " 个");
                    //   list.add("" + i);
                    if (taskQueen.getTaskQueen().size() >= num) {
//                        System.out.println("生产者停止");
                        logger.info("生产者停止...");
                        lock.notify();
                        lock.wait();
                    }
                }
            }
        } catch (Exception e) {
            //
        }


        //   taskQueen.addAll(hiveDataMap);
    }

    private List<CNGovDataUrl> getHiveDataList(Connection hiveCon, String hiveSql) {

        logger.info("开始查询hive数据...");
        logger.info("start to query hive data...");
        long startTime = System.currentTimeMillis();
        Statement statement = null;
        try {
            statement = hiveCon.createStatement();
            ResultSet rs = statement.executeQuery(hiveSql);
            long time = System.currentTimeMillis();
            long a = (time - startTime) / 1000;
            logger.info("查询完成,耗时" + a + "秒");
            logger.info("query finish, spend " + a + " s");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<CNGovDataUrl> dataList = new LinkedList<>();
            //    List<JSONObject> dataUrls = new LinkedList<>();
            while (rs.next()) {
                Map jsonObj = new HashMap();
                //    Map<String, String> map = new HashMap<>();
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    //     jsonObj.put(columnName.replaceAll("ods_zfcg\\.",""), value);
                    jsonObj.put(columnName.split("\\.")[1], value);
                }

                CNGovDataUrl govData = BeanUtil.mapToBean(jsonObj, CNGovDataUrl.class, true);
                //    CNGovDataUrl govData = jsonObj.toJavaObject(CNGovDataUrl.class);
                dataList.add(govData);
            }
            //    BeanUtil.mapToBean();
            long endTime = System.currentTimeMillis();
            long l = (endTime - startTime) / 1000;
            logger.info("查询转换完成,耗时" + l + "秒");
            logger.info("query and convent finish ,use time" + l + "s");
            return dataList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private List<Map<String, String>> getHiveDataMap(Connection hiveCon, String hiveSql) {
        hiveSql = "select * from ods_zfcg_content limit 10000";
        logger.info("开始查询hive数据...");
        logger.info("start to query hive data...");
        long startTime = System.currentTimeMillis();
        Statement statement = null;
        try {
            if(hiveCon.isClosed()){
                hiveCon = HiveJdbcConUtil.getConnnection();
            }
            statement = hiveCon.createStatement();
            ResultSet rs = statement.executeQuery(hiveSql);
            long time = System.currentTimeMillis();
            long a = (time - startTime) / 1000;
            logger.info("查询完成,耗时" + a + "秒");
            logger.info("query finish, spend " + a + " s");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<Map<String, String>> dataMapList = new LinkedList<>();
            //    List<JSONObject> dataUrls = new LinkedList<>();
            while (rs.next()) {
                Map jsonObj = new HashMap();
                //    Map<String, String> map = new HashMap<>();
                // 遍历每一列
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    //     jsonObj.put(columnName.replaceAll("ods_zfcg\\.",""), value);
                    jsonObj.put(columnName.split("\\.")[1], value);
                }

                //    CNGovDataUrl govData = BeanUtil.mapToBean(jsonObj, CNGovDataUrl.class, true);
                //    CNGovDataUrl govData = jsonObj.toJavaObject(CNGovDataUrl.class);
                dataMapList.add(jsonObj);
            }
            //    BeanUtil.mapToBean();
            long endTime = System.currentTimeMillis();
            long l = (endTime - startTime) / 1000;
            logger.info("查询转换完成,耗时" + l + "秒");
            logger.info("query and convent finish ,use time" + l + "s");
            return dataMapList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
