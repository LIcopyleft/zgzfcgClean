package com.drc.zfgc.thread.bigdata;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.drc.zfgc.contant.ContantCN;
import com.drc.zfgc.mapper.mysql.DataContentMapper;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.pool.IConnectionPool;
import com.drc.zfgc.pool.impl.HBaseConnectionPool;
import com.drc.zfgc.pool.impl.HiveConnectionPool;
import com.drc.zfgc.thread.DataBusinessDel;
import com.drc.zfgc.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hive.ql.metadata.Hive;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @description  政府采购数据清洗 : hive 读取 清洗后插入 hbase
 * @author tengchao.li
 * @date 2020/11/5
 * @param null
 * @return
 */
public class BigDataCleanTask implements Runnable {

    private int beginIndex;
    private int endIndex;
    private String hiveSql;
    private HBaseConnectionPool hBaseConPool;
    private HiveConnectionPool hiveConnPool;
    private ConfigParam config;

    private static final Logger logger = LoggerFactory.getLogger(BigDataCleanTask.class);


    public BigDataCleanTask(int beginIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.config = config;
    }

    public BigDataCleanTask(int beginIndex, int endIndex, ConfigParam config) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.config = config;
    }


    public BigDataCleanTask(int beginIndex, int endIndex, String hivesql, ConfigParam config, HiveConnectionPool hivePool, HBaseConnectionPool hbsePool) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.hiveSql = hivesql;
        this.config = config;
        this.hBaseConPool = hbsePool;
        this.hiveConnPool = hivePool;
    }

    @Override
    public void run() {
        org.apache.hadoop.hbase.client.Connection hbaseCon = null;
        try {
            List<Map<String, Object>> list = new LinkedList();
            //    List<Map<String, Object>> lists = new Vector<>();
            //List<CNGovDataUrl> dataContent = mapper.selectAll4(beginIndex, endIndex, config.getCleanTableName());
            Connection hiveCon = hiveConnPool.getConnection();
            List<CNGovDataUrl> hiveDataList = getHiveDataList(hiveCon);

            if (hiveDataList == null || hiveDataList.size() < 1) {
                logger.warn(Thread.currentThread().getName() + "end====query db is null====beginIndex=" + beginIndex);
                return;
            }
            logger.info("start to clean data...");
            for (CNGovDataUrl data : hiveDataList) {
                //     CNGovDataUrl data = queues.poll();
                try {
                    if (config.getColumnFamily().equals("htgg")){
                        data.setCategory("htgg");
                    }
                    String content = data.getContent();
                    if (StringUtils.isBlank(content)) {
                        continue;
                    }
                    /*
                     * @description  清洗逻辑
                     */
                    CNGovCleanData cleanData = CleanMethod.clean(data);
                    logger.debug("\r\n" + "[" + data.getType() + "]对象关键信息:" + data.toString());
                    if (cleanData == null) {
                        continue;
                    }
                    // data.setContent(null);
                    //   ap<String, Object> dataMap = ;
                    list.add(BeanUtil.beanToMap(cleanData));
                } catch (Exception e) {
                    logger.error("ParaseErr{urlId:" + data.getUrlId() + "====url:" + data.getUrl() + "}", e);
                    continue;
                }

            }
            hiveConnPool.recycle(hiveCon);
            logger.info("clean data over...");
            // 开始写入 hbase
            logger.info("开始插入hbase ==========================================");
            logger.info("start to insert hbase ==========================================");
            hbaseCon = hBaseConPool.getConnection();
            int num = 0;
            List<Map<String, Object>> dataList = new LinkedList<>();
            //   HBaseJdbcConUtil.putDataList(hbaseCon, "test_hbase", "zfcg", list);
            for (Map map : list) {
                num++;
                dataList.add(map);
                if (dataList.size() == config.getInsertMax() || num == list.size()) {

                    HBaseJdbcConUtil.putDataList(hbaseCon, config.getInsertTableName(), config.getColumnFamily(), dataList);
                    //    int row = mapper.insertCNCleanDataList(list, config.getInsertTableName());
                    config.getFinishNum().addAndGet(dataList.size());
                    //     logger.info(Thread.currentThread().getName() + "==url_id over" + dataContent.get(dataContent.size() - 1).getUrlId() + "=====insert\t" + row + "行");
                    dataList.clear();
                    continue;
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            logger.info("已插入" + config.getFinishNum().toString());
            logger.info("over insert num  " + config.getFinishNum().toString());
            hBaseConPool.recycle(hbaseCon);
            config.getLatch().countDown();
        }
    }

    private List<CNGovDataUrl> getHiveDataList(Connection hiveCon) throws SQLException {

        logger.info("开始查询hive数据...");
        logger.info("start to query hive data...");
        long startTime = System.currentTimeMillis();
        Statement statement = hiveCon.createStatement();
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
    }

    //


}
