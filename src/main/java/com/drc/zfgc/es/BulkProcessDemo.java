package com.drc.zfgc.es;


import cn.hutool.core.bean.BeanUtil;
import com.drc.zfgc.model.CNGovDataUrl;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * @author Ye
 * @time 2019年3月29日
 * <p>
 * 类说明：通过BulkProcess批量将Mysql数据导入ElasticSearch中
 */

public class BulkProcessDemo {

    private static final Logger logger = LogManager.getLogger(BulkProcessDemo.class);


  /*  public static void main(String[] args) throws InterruptedException, IOException {
        long start = System.currentTimeMillis();
        int beginIndex = 0;
        // int totalSize = 329318;//mapper.getTotal();
        //     int totalSize = 4448;//mapper.getTotal();
//       int totalSize = mapper.countNum(CLEAN_TABLE_NAME);
        //9219597
        int totalSize = 9219597;

        int maxUrlId = 15603920;

        System.out.println("数据总量为" + totalSize);

        int times = maxUrlId / QUERY_SIZE;
        *//*if (totalSize % QUERY_SIZE != 0) {
            times = times + 1;
        }*//*
        if (maxUrlId % QUERY_SIZE != 0) {
            times = times + 1;
        }
        CountDownLatch latch = new CountDownLatch(Integer.valueOf(String.valueOf(times)));

       *//* ConfigParam config = new ConfigParam();
        config.setCleanTableName(CLEAN_TABLE_NAME);
        config.setInsertTableName(INSERT_TABLE_NAME);
        config.setInsertMax(INSERT_MAX);
        config.setQuerySize(QUERY_SIZE);
        config.setLatch(latch);
        config.setStage(STAGE);
        config.setOpen(FLAG);
        config.setTableNum(TABLE_SIZE);// 0,清洗不含表格 1,表格数量为1 ,2 全部
        config.setUnionTableName(UNION_TABLE_NAME);
        config.setUseUnionTable(IS_QUERY_UNION);*//*

        String tableName = "cn_gov_purchase_index";
        String typeName = "cn_gov_purchase_type";
        createIndex(tableName);
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("20.0.0.100", 9200, "http")));
        BulkProcessor bulkProcessor = getBulkProcessor(client);

        Connection conn = DBHelper.getConn();


        for (int i = 0; i < times; i++) {
            int endIndex = beginIndex + QUERY_SIZE;
            // Runnable task = new CNGOVDataCleanTask(beginIndex, endIndex,config);
            beginIndex += QUERY_SIZE;

            sql += "WHERE url_id >= " + beginIndex + " and url_id < " + endIndex + "";

            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    writeMysqlDataToES(tableName, typeName, sql, bulkProcessor,conn);
                    latch.countDown();
                }
            });
        }
        latch.await();
        EXECUTOR.shutdown();
        long end = System.currentTimeMillis();
        //    int num = mapper.countNum(INSERT_TABLE_NAME);
        //   System.out.println("共清洗政府采购数据" + num + "条");
        System.out.println("用时" + (end - start) / 1000 + "秒");


       *//* try {
            long startTime = System.currentTimeMillis();
            //        createIndex(tableName);
            writeMysqlDataToES(tableName, typeName, sql);
            logger.info(" use time: " + (System.currentTimeMillis() - startTime) / 1000 + "s");
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }*//*
    }*/

    /**
     * 创建索引
     *
     * @param indexName
     * @throws IOException
     */
    public static void createIndex(String indexName) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("20.0.0.100", 9200, "http")));
        // ES 索引默认需要小写，故笔者将其转为小写
        CreateIndexRequest requestIndex = new CreateIndexRequest(indexName.toLowerCase());
        // 注： 设置副本数为0，索引刷新时间为-1对大批量索引数据效率的提升有不小的帮助
        requestIndex.settings(Settings.builder().put("index.number_of_shards", 5)
                .put("index.number_of_replicas", 0)
                .put("index.refresh_interval", "-1"));

        CreateIndexResponse createIndexResponse = client.indices().create(requestIndex, RequestOptions.DEFAULT);
        client.close();
    }

    /**
     * 将mysql 数据查出组装成es需要的map格式，通过批量写入es中
     *
     * @param tableName
     */
    public static void writeMysqlDataToES(String tableName, String typeName, List<CNGovDataUrl> dataList) {
       /* try {
            createIndex(tableName);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // 初始化
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("20.0.0.100", 9200, "http")));
        BulkProcessor bulkProcessor = getBulkProcessor(client);

       /*try {
          //      dataList.add(map);
                // 每10万条写一次，不足的批次的最后再一并提交
                if (count % 100000 == 0) {
                    logger.info("Mysql handle data number : " + count);
                    // 将数据添加到 bulkProcessor 中
                    for (CNGovDataUrl hashMap2 : dataList) {
                        bulkProcessor.add(new IndexRequest(tableName.toLowerCase(), typeName, urlId == null ? "0" : urlId.toString())
                                .source(hashMap2));
                    }
                    // 每提交一次便将map与list清空
                    map.clear();
                    dataList.clear();
                }
            }*/

        // count % 100000 处理未提交的数据
        for (CNGovDataUrl hashMap2 : dataList) {
            Integer urlId = hashMap2.getUrlId();
            Gson gson = new Gson();
            Map<String, Object> stringObjectMap = BeanUtil.beanToMap(hashMap2);
            //   String json = gson.toJson(hashMap2);


            try {
                bulkProcessor.add(new IndexRequest(tableName.toLowerCase(), typeName, urlId == null ? "0" : urlId.toString()).source(stringObjectMap));

            } catch (Exception e) {
                System.out.println("失败--------");
            }

            System.out.println("成功...");
        }

        //    logger.info("-------------------------- Finally insert number total : " + count);
        // 将数据刷新到es, 注意这一步执行后并不会立即生效，取决于bulkProcessor设置的刷新时间


        bulkProcessor.flush();


    } /*finally {
            try {

                boolean terminatedFlag = bulkProcessor.awaitClose(150L, TimeUnit.SECONDS);
                  client.close();
                logger.info(terminatedFlag);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }*/

public static void Abc(RestHighLevelClient client ,BulkRequest request, ActionListener bulkListener){

    return;
}
    /**
     * 创建bulkProcessor并初始化
     *
     * @param client
     * @return
     */
    private static BulkProcessor getBulkProcessor(RestHighLevelClient client) {

        BulkProcessor bulkProcessor = null;
        try {

           /* BulkProcessor.Listener listener = new BulkProcessor.Listener() {
                @Override
                public void beforeBulk(long executionId, BulkRequest request) {
                    logger.info("Try to insert data number : " + request.numberOfActions());
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request, BulkResponse response) {
                    logger.info("************** Success insert data number : " + request.numberOfActions() + " , id: "
                            + executionId);
                }

                @Override
                public void afterBulk(long executionId, BulkRequest request, Throwable failure) {
                    logger.error("Bulk is unsuccess : " + failure + ", executionId: " + executionId);
                }
            };*/
            BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkRequestActionListenerBiConsumer = null;
            try {

                bulkRequestActionListenerBiConsumer = (request, bulkListener) -> client.bulkAsync(request, RequestOptions.DEFAULT, bulkListener);
                System.out.println(bulkRequestActionListenerBiConsumer);
            } catch (Exception e) {
                System.out.println("失败----222222----");
            }

            BiConsumer<BulkRequest, ActionListener<BulkResponse>> bulkConsumer = bulkRequestActionListenerBiConsumer;

            //	bulkProcessor = BulkProcessor.builder(bulkConsumer, listener).build();
           /* BulkProcessor.Builder builder = BulkProcessor.builder(bulkConsumer, listener);
            builder.setBulkActions(5000);
            builder.setBulkSize(new ByteSizeValue(100L, ByteSizeUnit.MB));
            builder.setConcurrentRequests(10);
            builder.setFlushInterval(TimeValue.timeValueSeconds(60L));
            builder.setBackoffPolicy(BackoffPolicy.constantBackoff(TimeValue.timeValueSeconds(1L), 3));
            // 注意点：在这里感觉有点坑，官网样例并没有这一步，而笔者因一时粗心也没注意，在调试时注意看才发现，上面对builder设置的属性没有生效
            bulkProcessor = builder.build();*/

        } catch (Exception e) {
            e.printStackTrace();
            try {
                bulkProcessor.awaitClose(300L, TimeUnit.SECONDS);
                client.close();
            } catch (Exception e1) {
                logger.error(e1.getMessage());
            }
        }
        return bulkProcessor;
    }
}
