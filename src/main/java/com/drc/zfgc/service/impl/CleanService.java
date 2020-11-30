package com.drc.zfgc.service.impl;

import com.drc.zfgc.thread.CNGOVDataCleanTask;
import com.drc.zfgc.thread.Mysql2MysqlTask;
import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.thread.CNGOVDataCleanUseContentTask;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description
 * @date 2020/10/21
 */

@Service
public class CleanService {
    private static Integer MAX_THREAD_NUM = 7;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_THREAD_NUM);
    private static final String STAGE = "政府采购";

    private static final String INSERT_TABLE_NAME = "temp_test";
    //   private static final String CLEAN_TABLE_NAME = "spider_2_ggzy_content_clean_temp";
    private static final String CLEAN_TABLE_NAME = "spider_71_ggzy_zgzfcgw_url";
    private static final String UNION_TABLE_NAME = "spider_71_ggzy_zgzfcgw_content";
    private static final int INSERT_MAX = 1000;
    private static final int QUERY_SIZE = 10000;
    private static final int TABLE_SIZE = 1;
    //是否开启单独清洗 表格数为特定值得记录
    private static final boolean FLAG = false;
    //是否开启使用查询 辅助表 完善字段
    private static final boolean IS_QUERY_UNION = true;

    static AtomicInteger atomic = new AtomicInteger(0);

    public void clean() throws InterruptedException {
        long start = System.currentTimeMillis();
        int beginIndex = 9219597;
        // int totalSize = 329318;//mapper.getTotal();
        //     int totalSize = 4448;//mapper.getTotal();
//       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
        //9219597
        int totalSize = 9219597;
    //    System.out.println("数据总量为" + totalSize);
       /* List<String> category = mapper.getCategory(CLEAN_TABLE_NAME);
        category.stream().forEach(item -> {
            System.out.println(item);
        });*/
        //endIndex  15603907

        int maxUrlId = 15603920;
        int times = (maxUrlId - beginIndex) / QUERY_SIZE;
       /* if (totalSize % QUERY_SIZE != 0) {
            times = times + 1;
        }*/
        if (maxUrlId % QUERY_SIZE != 0) {
            times = times + 1;
        }
        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));

        ConfigParam config = new ConfigParam();
        config.setCleanTableName(CLEAN_TABLE_NAME);
        config.setInsertTableName(INSERT_TABLE_NAME);
        config.setInsertMax(INSERT_MAX);
        config.setQuerySize(QUERY_SIZE);
        config.setLatch(latch);
        config.setStage(STAGE);
        config.setOpen(FLAG);
        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
        config.setUnionTableName(UNION_TABLE_NAME);
        config.setUseUnionTable(IS_QUERY_UNION);
        config.setFinishNum(atomic);
        for (int i = 0; i < times; i++) {
            int endIndex = beginIndex + QUERY_SIZE;
            Runnable task = new CNGOVDataCleanTask(beginIndex, endIndex, config);
            beginIndex += QUERY_SIZE;
            EXECUTOR.execute(task);
        }
        latch.await();
        EXECUTOR.shutdown();
        long end = System.currentTimeMillis();
        //    int num = mapper.countNum(INSERT_TABLE_NAME);
        //   System.out.println("共清洗政府采购数据" + num + "条");
        System.out.println("用时" + (end - start) / 1000 + "秒");

    }


    /*
     * @description  补采集数据使用,一般不使用
     * @author tengchao.li
     * @date 2020/10/28
     * @param null
     * @return

     */
    public void clean2() throws InterruptedException {
        long start = System.currentTimeMillis();
        int beginIndex = 11855476;

      /*  15603920
        11855476*/
        // int totalSize = 329318;//mapper.getTotal();
        //     int totalSize = 4448;//mapper.getTotal();
//       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
        //9219597
   //     int totalSize = 9219597;
    //    System.out.println("数据总量为" + totalSize);
       /* List<String> category = mapper.getCategory(CLEAN_TABLE_NAME);
        category.stream().forEach(item -> {
            System.out.println(item);
        });*/
        //endIndex  15603907

        int maxUrlId = 15603920;
        int times = (maxUrlId - beginIndex) / QUERY_SIZE;
       /* if (totalSize % QUERY_SIZE != 0) {
            times = times + 1;
        }*/
        if ((maxUrlId - beginIndex)  % QUERY_SIZE != 0) {
            times = times + 1;
        }
        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));

        ConfigParam config = new ConfigParam();
        config.setCleanTableName("spider_71_ggzy_zgzfcgw_content_1");
        config.setInsertTableName(INSERT_TABLE_NAME);
        config.setInsertMax(INSERT_MAX);
        config.setQuerySize(QUERY_SIZE);
        config.setLatch(latch);
        config.setStage(STAGE);
        config.setOpen(FLAG);
        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
        config.setUnionTableName("spider_71_ggzy_zgzfcgw_url");
        config.setUseUnionTable(IS_QUERY_UNION);
        config.setFinishNum(atomic);
        for (int i = 0; i < times; i++) {
            int endIndex = beginIndex + QUERY_SIZE;
            Runnable task = new CNGOVDataCleanUseContentTask(beginIndex, endIndex, config);
            beginIndex += QUERY_SIZE;
            EXECUTOR.execute(task);
        }
        latch.await();
        EXECUTOR.shutdown();
        long end = System.currentTimeMillis();
        //    int num = mapper.countNum(INSERT_TABLE_NAME);
        //   System.out.println("共清洗政府采购数据" + num + "条");
        System.out.println("用时" + (end - start) / 1000 + "秒");

    }



    public void mysql2mysql() throws InterruptedException {
        long start = System.currentTimeMillis();
        int beginIndex = 11855476;
        // int totalSize = 329318;//mapper.getTotal();
        //     int totalSize = 4448;//mapper.getTotal();
//       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
        //9219597
        int totalSize = 9219597;
        //    System.out.println("数据总量为" + totalSize);
       /* List<String> category = mapper.getCategory(CLEAN_TABLE_NAME);
        category.stream().forEach(item -> {
            System.out.println(item);
        });*/
        //endIndex  15603907
    //    9219607
        int maxUrlId = 15603920;
        int times = (maxUrlId - beginIndex) / QUERY_SIZE;
       /* if (totalSize % QUERY_SIZE != 0) {
            times = times + 1;
        }*/
        if ((maxUrlId - beginIndex) % QUERY_SIZE != 0) {
            times = times + 1;
        }
        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));

        ConfigParam config = new ConfigParam();
        config.setCleanTableName("temp_test");
        config.setInsertTableName("temp_test_中国政府采购_1");
        config.setInsertMax(INSERT_MAX);
        config.setQuerySize(QUERY_SIZE);
        config.setLatch(latch);
        config.setStage(STAGE);
        config.setOpen(FLAG);
        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
        config.setUnionTableName(UNION_TABLE_NAME);
        config.setUseUnionTable(IS_QUERY_UNION);
        config.setFinishNum(atomic);
        for (int i = 0; i < times; i++) {
            int endIndex = beginIndex + QUERY_SIZE;
            Runnable task = new Mysql2MysqlTask(beginIndex, endIndex, config);
            beginIndex += QUERY_SIZE;
            EXECUTOR.execute(task);
        }
        latch.await();
        EXECUTOR.shutdown();
        long end = System.currentTimeMillis();
        //    int num = mapper.countNum(INSERT_TABLE_NAME);
        //   System.out.println("共清洗政府采购数据" + num + "条");
        System.out.println("用时" + (end - start) / 1000 + "秒");

    }


}
