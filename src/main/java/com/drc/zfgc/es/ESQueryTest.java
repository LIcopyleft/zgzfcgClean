package com.drc.zfgc.es;


import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;


/**
 * @author tengchao.li
 * @description
 * @date 2020/9/25
 */
public class ESQueryTest {
    private String index = "zg_zfcg_index";
    private String type = "zg_zfcg_index";

    RestHighLevelClient client = ESClient.getClient();
    @Test
    public void testConnect(){

        RestHighLevelClient client = ESClient.getClient();

        System.out.println("ok");
//        client

    }

    public void createIndex() throws IOException {

        Settings.Builder settings = Settings.builder()
                .put("number_of_shards", 3)
                .put("number_of_replicas", 0);

        //准备关于索引的结构mappings
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                    .startObject("properties")
                        .startObject("name")
                            // 指定类型
                            .field("type","text")
                        .endObject()
                        .startObject("age")
                            .field("type","integer")
                        .endObject()
                        .startObject("birthday")
                            .field("type","integer")
                            .field("format","yyyy-MM-dd")
                        .endObject()
                    .endObject()
                .endObject();

       // settings
      //  将settings 和 mappings 封装到Request对象中


        CreateIndexRequest request = new CreateIndexRequest(index).settings(settings);
        request.mapping(type,mappings);

      //  client.index(request, );

    }

    @Test
    public void termQuery() throws IOException {
        SearchRequest request = new SearchRequest(index,type);

        //指定查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        int maxValue = Integer.MAX_VALUE;
        builder.size(10000);

        builder.query(QueryBuilders.termQuery("region","天津市"));

        request.source(builder);

        SearchResponse search = client.search(request);

        Aggregations aggregations = search.getAggregations();

        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits){

          /*  Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            System.out.println(sourceAsMap);*/
        }

      //  Map<String, Aggregation> stringAggregationMap = aggregations.asMap();



    }

    /*
    *   term : where region = 北京市
    *
    *   terms : where region = 北京市 or region = ??? or
    *
    *   同样会对指定的查询关键字进行分词, 直接去分词库中匹配,找到响应文档
    *
    * */
    @Test
    public void termsQuery() throws IOException {

        SearchRequest request = new SearchRequest(index,type);



        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(10000);


        builder.query(QueryBuilders.termsQuery("region","北京市","天津市","陕西省"));
        request.source(builder);

        SearchResponse searchResponse = client.search(request);

        res2Map(searchResponse);

    }

    /*
    *  数据高层查询, 会根据查询的字段类型不一样采用不同的查询方式.
    *
    *   查询的是日期或者是数值的话, 会将你基于字符串查询的的内容转换为日期或者数值对待
    *   如果查询的内容是以一个不能被分词的内容,match查询不会对你指定的查询关键字进行分词
    *
    *   如果查询内容是一个可以被分词的内容(text) . match会将你的指定查询内容根据一定的方式去分词
    *   去分词库中匹配指定的内容
    *
    *   底层是多个term的封装
    *
    * */
    @Test
    public void matchAll(){


    }


    @Test
    public void match() throws IOException {
        SearchRequest request = new SearchRequest(index,type);

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchQuery("rowkey","北京统计公报"));


        request.source(builder);
        SearchResponse search = client.search(request);

        res2Map(search);


    }

    /*
     * @description   布尔match查询
     * @author tengchao.li
     * @date 2020/9/25
     * @param null
     * @return
     */



    private void res2Map(SearchResponse searchResponse) {
        SearchHit[] hits = searchResponse.getHits().getHits();
        for(SearchHit hit : hits){
           // Map<String, Object> sourceAsMap = hit.getSourceAsMap();
           // System.out.println(sourceAsMap);
        }


    }


}
