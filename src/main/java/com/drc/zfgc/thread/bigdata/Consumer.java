package com.drc.zfgc.thread.bigdata;

import cn.hutool.core.bean.BeanUtil;
import com.drc.zfgc.model.CNGovCleanData;
import com.drc.zfgc.model.CNGovDataUrl;
import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.model.TaskQueen;
import com.drc.zfgc.pool.impl.HBaseConnectionPool;
import com.drc.zfgc.utils.CleanMethod;
import com.drc.zfgc.utils.ConventUtils;
import com.drc.zfgc.utils.HBaseJdbcConUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hbase.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author tengchao.li
 * @description 数据消费者, 清洗任务加插入hbase
 * @date 2020/11/11
 */
public class Consumer implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger("Consumer");

    private String hiveSql;
    private Vector<Map<String, Object>> list;
    private TaskQueen taskQueen;
    private ConfigParam config;
    private String lock;


    private HBaseConnectionPool hbasePool;


    public Consumer(HBaseConnectionPool hbasePool, TaskQueen taskQueen, ConfigParam config, String lock) {
        this.hbasePool = hbasePool;
        this.taskQueen = taskQueen;
        this.config = config;
        this.lock = lock;
        this.list = new Vector<Map<String, Object>>(config.getInsertMax());

    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                Connection hbaseCon = HBaseJdbcConUtil.getCon();
                logger.info("开始消费..............");
                for (; ; ) {
                    if (taskQueen.getTaskQueen().size() == 0) {
                        logger.info("消费等待..............");
                        lock.wait();
                    }

                    List<Map<String, String>> dataMapList = taskQueen.consume();
                    for(Map data : dataMapList){
                        try {
                            /*
                             * @description  清洗逻辑
                             */
                            CNGovCleanData cleanData = CleanMethod.clean(data);
                        //    logger.debug("\r\n" + "[" + data.getType() + "]对象关键信息:" + data.toString());
                            if (cleanData == null) {
                                continue;
                            }
                            // data.setContent(null);
                            //   ap<String, Object> dataMap = ;
                            list.add(BeanUtil.beanToMap(cleanData));
                            logger.info("task queen size :" + list.size());
                            //TODO

                        } catch (Exception e) {
                        //    logger.error("ParaseErr{urlId:" + data.getUrlId() + "====url:" + data.getUrl() + "}", e);
                            logger.error(data.toString(), e);
                            continue;
                        }

                    }
                    if (list.size() >= 0 || taskQueen.getTaskQueen().size() == 0) {
                        logger.info("开始插入hbase ==========================================");
                        logger.info("start to insert hbase ==========================================");
                        //   Connection hbaseCon = hbasePool.getConnection();
                        if (hbaseCon.isClosed()) {
                            hbaseCon = HBaseJdbcConUtil.getCon();
                        }

                        //   HBaseJdbcConUtil.putDataList(hbaseCon, "test_hbase", "zfcg", list);

                        //    HBaseJdbcConUtil.putDataList(hbaseCon, config.getInsertTableName(), config.getColumnFamily(), list);
                        HBaseJdbcConUtil.putDataListAsy(hbaseCon, config.getInsertTableName(), config.getColumnFamily(), list, config.getFinishNum());
                        //    int row = mapper.insertCNCleanDataList(list, config.getInsertTableName());
                   //     config.getFinishNum().addAndGet(list.size());
                        //     logger.info(Thread.currentThread().getName() + "==url_id over" + dataContent.get(dataContent.size() - 1).getUrlId() + "=====insert\t" + row + "行");
                        list.clear();
                        //    HBaseJdbcConUtil.closeConnection(hbaseCon);
                    //    logger.info("finish insert\t" + config.getFinishNum().toString());
                        logger.info("本次消费完了");
                        lock.notify();
                    }

                }

            }
        } catch (Exception e) {
        }


    }

}
