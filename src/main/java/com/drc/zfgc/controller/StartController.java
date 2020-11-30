//package com.drc.zfgc.controller;
//
//
//import com.drc.zfgc.service.impl.CleanService;
//import com.drc.zfgc.service.impl.CleanHTGGService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author tengchao.li
// * @description
// * @date 2020/8/31
// */
//@RestController
//@RequestMapping("/test")
//public class StartController {
//   /* private static Integer MAX_THREAD_NUM = 7;
//    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_THREAD_NUM);
//    private static final String STAGE = "政府采购";
//
//    private static final String INSERT_TABLE_NAME = "temp_clean_data2";
//    //   private static final String CLEAN_TABLE_NAME = "spider_2_ggzy_content_clean_temp";
//    private static final String CLEAN_TABLE_NAME = "spider_71_ggzy_zgzfcgw_url";
//    private static final String UNION_TABLE_NAME = "spider_71_ggzy_zgzfcgw_content";
//    private static final int INSERT_MAX = 1000;
//    private static final int QUERY_SIZE = 10000;
//    private static final int TABLE_SIZE = 1;
//    //是否开启单独清洗 表格数为特定值得记录
//    private static final boolean FLAG = false;
//    //是否开启使用查询 辅助表 完善字段
//    private static final boolean IS_QUERY_UNION = true;
//    private static boolean FLAG_START = true;*/
//
//    //获取ApplicationContext对象方式有多种,这种最简单,其它的大家自行了解一下
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private CleanService service;
//    @Autowired
//    private CleanHTGGService htggService;
//
//
//    @GetMapping("/test")
//    public String test() throws InterruptedException {
//
//
//        //这样调用同类下的异步方法是不起作用的               //this.testAsyncTask();             //通过上下文获取自己的代理对象调用异步方法
//        /*StartController startController = (StartController) applicationContext.getBean(StartController.class);
//        startController.clean();*/
//     //   service.clean();
//     //   htggService.clean();
//
//        //    startController.fromEsclean();
//        return "程序执行中";
//
//    }
//
//    @GetMapping("/bucai")
//    public String addData() throws InterruptedException {
//
//
//        //这样调用同类下的异步方法是不起作用的               //this.testAsyncTask();             //通过上下文获取自己的代理对象调用异步方法
//        /*StartController startController = (StartController) applicationContext.getBean(StartController.class);
//        startController.clean();*/
//        service.clean2();
//     //   htggService.clean();
//
//        //    startController.fromEsclean();
//        return "补采清洗程序执行中";
//
//    }
//
//    @GetMapping("/qianyi")
//    public String mysql2mysql() throws InterruptedException {
//
//
//        //这样调用同类下的异步方法是不起作用的               //this.testAsyncTask();             //通过上下文获取自己的代理对象调用异步方法
//        /*StartController startController = (StartController) applicationContext.getBean(StartController.class);
//        startController.clean();*/
//        service.mysql2mysql();
//        //   htggService.clean();
//
//        //    startController.fromEsclean();
//        return "迁移程序执行中";
//
//    }
//
//
//
//
//    /*public void fromEsclean() throws IOException {
//
//        String script = "{\n" +
//                "  \"query\": {\n" +
//                "    \"range\": {\n" +
//                "      \"url_id\": {\n" +
//                "        \"gte\": 1,\n" +
//                "        \"lte\": 100000000001\n" +
//                "      }\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"sort\": [\n" +
//                "    {\n" +
//                "      \"url_id\": {\n" +
//                "        \"order\": \"asc\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//
//        JestClient client = ElasticSearchUtils.jestClient();
//        ElasticSearchUtils.scroll(client, "zfcg_71@spider_2020", "_doc", script,null, CNGovDataEsExample.class);
//
//
//    }*/
//
//    public static void main(String[] args) {
//
//        StringBuilder sb = new StringBuilder("select * from spider_71_ggzy_zgzfcgw_url where url_id in (");
//        int i = 10000000;
//        int times = 20000;
//        while (times > 0) {
//            times--;
//            sb.append(++i).append(",");
//        }
//
//        StringBuilder append = sb.delete(sb.length() - 1, sb.length()).append(")");
//        System.out.println(append.toString());
//    }
//
//
//   /* @Async
//    public void clean() throws InterruptedException {
//
//        synchronized (this) {
//            if (FLAG_START) {
//                FLAG_START = false;
//            } else {
//                System.err.print("请勿重复执行....");
//            }
//        }
//
//        long start = System.currentTimeMillis();
//        int beginIndex = 0;
//        // int totalSize = 329318;//mapper.getTotal();
//        //     int totalSize = 4448;//mapper.getTotal();
////       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
//        //9219597
//        //    int totalSize = 9219597;
//
//        int maxUrlId = 15603920;
//
//        //    System.out.println("数据总量为" + totalSize);
//
//        int times = maxUrlId / QUERY_SIZE;
//        *//*if (totalSize % QUERY_SIZE != 0) {
//            times = times + 1;
//        }*//*
//        if (maxUrlId % QUERY_SIZE != 0) {
//            times = times + 1;
//        }
//        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));
//
//        ConfigParam config = new ConfigParam();
//        config.setCleanTableName(CLEAN_TABLE_NAME);
//        config.setInsertTableName(INSERT_TABLE_NAME);
//        config.setInsertMax(INSERT_MAX);
//        config.setQuerySize(QUERY_SIZE);
//        config.setLatch(latch);
//        config.setStage(STAGE);
//        config.setOpen(FLAG);
//        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
//        config.setUnionTableName(UNION_TABLE_NAME);
//        config.setUseUnionTable(IS_QUERY_UNION);
//        for (int i = 0; i < times; i++) {
//            int endIndex = beginIndex + QUERY_SIZE;
//            Runnable task = new CNGOVDataCleanTask_bak1(beginIndex, endIndex, config);
//            beginIndex += QUERY_SIZE;
//            EXECUTOR.execute(task);
//        }
//        latch.await();
//        EXECUTOR.shutdown();
//        long end = System.currentTimeMillis();
//        //    int num = mapper.countNum(INSERT_TABLE_NAME);
//        //   System.out.println("共清洗政府采购数据" + num + "条");
//        System.out.println("用时" + (end - start) / 1000 + "秒");
//    }
//
//
//    @Async
//    public void mysql2Es() throws InterruptedException {
//
//        synchronized (this) {
//            if (FLAG_START) {
//                FLAG_START = false;
//            } else {
//                System.err.print("请勿重复执行....");
//            }
//        }
//
//        long start = System.currentTimeMillis();
//        int beginIndex = 0;
//        // int totalSize = 329318;//mapper.getTotal();
//        //     int totalSize = 4448;//mapper.getTotal();
////       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
//        //9219597
//        int totalSize = 9219597;
//
//        int maxUrlId = 15603920;
//
//        System.out.println("数据总量为" + totalSize);
//
//        int times = maxUrlId / QUERY_SIZE;
//
//        if (maxUrlId % QUERY_SIZE != 0) {
//            times = times + 1;
//        }
//        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));
//
//        ConfigParam config = new ConfigParam();
//        config.setCleanTableName(CLEAN_TABLE_NAME);
//        config.setInsertTableName(INSERT_TABLE_NAME);
//        config.setInsertMax(INSERT_MAX);
//        config.setQuerySize(QUERY_SIZE);
//        config.setLatch(latch);
//        config.setStage(STAGE);
//        config.setOpen(FLAG);
//        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
//        config.setUnionTableName(UNION_TABLE_NAME);
//        config.setUseUnionTable(IS_QUERY_UNION);
//        for (int i = 0; i < times; i++) {
//            int endIndex = beginIndex + QUERY_SIZE;
//            Runnable task = new Mysql2ESTask(beginIndex, endIndex, config);
//            beginIndex += QUERY_SIZE;
//            EXECUTOR.execute(task);
//        }
//        latch.await();
//        EXECUTOR.shutdown();
//        long end = System.currentTimeMillis();
//        //    int num = mapper.countNum(INSERT_TABLE_NAME);
//        //   System.out.println("共清洗政府采购数据" + num + "条");
//        System.out.println("用时" + (end - start) / 1000 + "秒");
//    }*/
//
//}
