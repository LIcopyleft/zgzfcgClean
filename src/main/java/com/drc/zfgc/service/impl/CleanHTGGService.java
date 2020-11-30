package com.drc.zfgc.service.impl;

import com.drc.zfgc.model.ConfigParam;
import com.drc.zfgc.thread.CNGovHtggDataCleanTask;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tengchao.li
 * @description 合同公告处理
 * @date 2020/10/21
 */

@Service
public class CleanHTGGService {
    private static Integer MAX_THREAD_NUM = 7;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_THREAD_NUM);
    private static final String STAGE = "政府采购";

    private static final String INSERT_TABLE_NAME = "temp_test_htgg";
    //   private static final String CLEAN_TABLE_NAME = "spider_2_ggzy_content_clean_temp";
    private static final String CLEAN_TABLE_NAME = "spider_71_cgpt_data_url";
    private static final String UNION_TABLE_NAME = "spider_71_ggzy_zgzfcgw_content";
    private static final int INSERT_MAX = 1000;
    private static final int QUERY_SIZE = 1000;
    private static final int TABLE_SIZE = 1;
    //是否开启单独清洗 表格数为特定值得记录
    private static final boolean FLAG = false;
    //是否开启使用查询 辅助表 完善字段
    private static final boolean IS_QUERY_UNION = false;

    static AtomicInteger atomic = new AtomicInteger(0);

    public void clean() throws InterruptedException {
        long start = System.currentTimeMillis();
        int beginIndex = 0;
        // int totalSize = 329318;//mapper.getTotal();
        //     int totalSize = 4448;//mapper.getTotal();
//       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
        //9219597
        int totalSize = 576495;

        System.out.println("数据总量为" + totalSize);
       /* List<String> category = mapper.getCategory(CLEAN_TABLE_NAME);
        category.stream().forEach(item -> {
            System.out.println(item);
        });*/
        //endIndex  15603907

      /*  int times = totalSize / QUERY_SIZE;
        if (totalSize % QUERY_SIZE != 0) {
            times = times + 1;
        }*/


        int maxUrlId = 592312;
        int times = maxUrlId / QUERY_SIZE;

        if (maxUrlId % QUERY_SIZE != 0) {
            times = times + 1;
        }

        System.out.println("总需要执行次数:    " + times + "   次");
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
            Runnable task = new CNGovHtggDataCleanTask(beginIndex, endIndex, config);
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
