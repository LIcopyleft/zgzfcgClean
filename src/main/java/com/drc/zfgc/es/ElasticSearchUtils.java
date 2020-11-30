package com.drc.zfgc.es;

import com.drc.zfgc.thread.CleanEsCNGovTask;
import com.google.gson.Gson;
import com.drc.zfgc.model.CNGovDataEsExample;
import io.searchbox.action.AbstractAction;
import io.searchbox.action.BulkableAction;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import io.searchbox.core.SearchResult.Hit;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.params.Parameters;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.slice.SliceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ElasticSearch工具
 *
 * @author qi.sun
 * @time 2019-7-9 17:49:17
 */
public class ElasticSearchUtils {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ElasticSearchUtils.class);

    public static boolean indicesExists(JestClient jestClient,
                                        String indexName) {
        IndicesExists indicesExists = new IndicesExists.Builder(indexName)
                .build();
        try {
            JestResult jestResult = jestClient.execute(indicesExists);
            boolean succeeded = jestResult.isSucceeded();
            return succeeded;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createIndex(JestClient jestClient, String indexName,
                                      String settings, String mappings) {
        CreateIndex createIndex = new CreateIndex.Builder(indexName)
                .settings(settings).mappings(mappings).build();
        try {
            JestResult jestResult = jestClient.execute(createIndex);
            boolean succeeded = jestResult.isSucceeded();
            return succeeded;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteIndex(JestClient jestClient, String indexName) {
        DeleteIndex deleteIndex = new DeleteIndex.Builder(indexName).build();
        try {
            JestResult jestResult = jestClient.execute(deleteIndex);
            boolean succeeded = jestResult.isSucceeded();
            return succeeded;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 新增/覆盖数据
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @return 是否成功
     */
    public static <T> boolean index(JestClient jestClient, String indexName,
                                    String typeName, T t, boolean refresh) {
        Index data = new Index.Builder(t).index(indexName).type(typeName)
                .refresh(refresh).build();
        try {
            DocumentResult documentResult = jestClient.execute(data);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("新增失败");
            return false;
        }
    }

    /**
     * 删除数据
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param id         主键
     * @return 是否成功
     */
    public static boolean delete(JestClient jestClient, String indexName,
                                 String typeName, String id, boolean refresh) {
        Delete delete = new Delete.Builder(id).index(indexName).type(typeName)
                .refresh(refresh).build();
        try {
            DocumentResult documentResult = jestClient.execute(delete);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("删除失败");
            return false;
        }
    }

    /**
     * 修改数据
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @param id         主键
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
                                     String typeName, T t, String id, boolean refresh) {
        if (id == null) {
            return false;
        }
        Map<String, Object> doc = new HashMap<>();
        doc.put("doc", t);
        Gson gson = new Gson();
        String json = gson.toJson(doc);
        Update update = new Update.Builder(json).id(id).index(indexName)
                .type(typeName).refresh(refresh).build();
        try {
            DocumentResult documentResult = jestClient.execute(update);
            return documentResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("修改失败");
            return false;
        }
    }

    /**
     * 修改数据
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param t          数据
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
                                     String typeName, T t, boolean refresh) {
        String id = AbstractAction.getIdFromSource(t);
        return update(jestClient, indexName, typeName, t, id, refresh);
    }

    /**
     * 批量处理
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param actions    处理动作
     * @return 是否成功
     */
    public static boolean bulk(JestClient jestClient, String indexName,
                               String typeName,
                               Collection<? extends BulkableAction<DocumentResult>> actions,
                               boolean refresh) {
        Bulk.Builder builder = new Bulk.Builder().defaultIndex(indexName)
                .defaultType(typeName).refresh(refresh);
        builder.addAction(actions);
        try {
            BulkResult bulkResult = jestClient.execute(builder.build());
            return bulkResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("批量处理失败");
            return false;
        }
    }

    /**
     * 批量处理
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param loop       处理函数
     * @return 是否成功
     */
    public static boolean bulk(JestClient jestClient, String indexName,
                               String typeName, Predicate<Bulk.Builder> loop, boolean refresh) {
        Bulk.Builder builder = new Bulk.Builder().defaultIndex(indexName)
                .defaultType(typeName).refresh(refresh);
        boolean test = loop.test(builder);
        if (test) {
            try {
                BulkResult bulkResult = jestClient.execute(builder.build());
                return bulkResult.isSucceeded();
            } catch (IOException e) {
                LOGGER.error("批量处理失败");
                return false;
            }
        } else {
            LOGGER.error("批量处理失败");
            return false;
        }
    }

    /**
     * 批量新增/覆盖
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param list       数据集合
     * @return 是否成功
     */
    public static <T> boolean index(JestClient jestClient, String indexName,
                                    String typeName, List<T> list, boolean refresh) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (T t : list) {
                Index data = new Index.Builder(t).build();
                builder.addAction(data);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop, refresh);
    }

    /**
     * 批量删除
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param ids        主键集合
     * @return 是否成功
     */
    public static boolean delete(JestClient jestClient, String indexName,
                                 String typeName, List<String> ids, boolean refresh) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (String id : ids) {
                Delete delete = new Delete.Builder(id).build();
                builder.addAction(delete);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop, refresh);
    }

    /**
     * 批量修改
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param map        主键数据映射
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
                                     String typeName, Map<String, T> map, boolean refresh) {
        Predicate<Bulk.Builder> loop = builder -> {
            Set<Entry<String, T>> entrySet = map.entrySet();
            for (Entry<String, T> entry : entrySet) {
                String id = entry.getKey();
                if (id == null) {
                    return false;
                }
                T t = entry.getValue();
                Map<String, Object> doc = new HashMap<>();
                doc.put("doc", t);
                Gson gson = new Gson();
                String json = gson.toJson(doc);
                Update update = new Update.Builder(json).id(id).build();
                builder.addAction(update);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop, refresh);
    }

    /**
     * 批量修改
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param list       数据集合
     * @return 是否成功
     */
    public static <T> boolean update(JestClient jestClient, String indexName,
                                     String typeName, List<T> list, boolean refresh) {
        Predicate<Bulk.Builder> loop = builder -> {
            for (T t : list) {
                String id = AbstractAction.getIdFromSource(t);
                if (id == null) {
                    return false;
                }
                Map<String, Object> doc = new HashMap<>();
                doc.put("doc", t);
                Gson gson = new Gson();
                String json = gson.toJson(doc);
                Update update = new Update.Builder(json).id(id).build();
                builder.addAction(update);
            }
            return true;
        };
        return bulk(jestClient, indexName, typeName, loop, refresh);
    }

    /**
     * 条件删除
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return 是否成功
     */
    public static <T> boolean deleteByQuery(JestClient jestClient,
                                            String indexName, String typeName, String script, boolean refresh) {
        DeleteByQuery deleteByQuery = new DeleteByQuery.Builder(script)
                .addIndex(indexName).addType(typeName).refresh(refresh).build();
        try {
            JestResult jestResult = jestClient.execute(deleteByQuery);
            return jestResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("删除失败");
            return false;
        }
    }

    /**
     * 条件修改
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return 是否成功
     */
    public static <T> boolean updateByQuery(JestClient jestClient,
                                            String indexName, String typeName, String script, boolean refresh) {
        UpdateByQuery updateByQuery = new UpdateByQuery.Builder(script)
                .addIndex(indexName).addType(typeName).refresh(refresh).build();
        try {
            UpdateByQueryResult updateByQueryResult = jestClient
                    .execute(updateByQuery);
            return updateByQueryResult.isSucceeded();
        } catch (IOException e) {
            LOGGER.error("修改失败");
            return false;
        }
    }

    /**
     * 检索
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return SearchResult
     */
    public static SearchResult search(JestClient jestClient, String indexName,
                                      String typeName, String script) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
                .addType(typeName).build();
        SearchResult searchResult = jestClient.execute(search);
        return searchResult;
    }

    /**
     * 检索
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param clazz      数据类型
     * @return 数据集合
     */
    public static <T> List<T> search(JestClient jestClient, String indexName,
                                     String typeName, String script, Class<T> clazz) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
                .addType(typeName).build();
        SearchResult searchResult = jestClient.execute(search);
        List<T> list = searchResult.getSourceAsObjectList(clazz, true);
        return list;
    }

    /**
     * 检索
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param scrollId   游标ID
     * @param clazz      数据类型
     * @return 游标ID及数据集合的映射：{"scrollId":游标ID,"list":数据集合}
     */
    public static <T> Map<String, Object> search(JestClient jestClient,
                                                 String indexName, String typeName, String script, String scrollId,
                                                 Class<T> clazz) throws IOException {
        JestResult jestResult = null;
        if (scrollId == null) {
            jestResult = scrollSearch(jestClient, indexName, typeName, script);
            scrollId = jestResult.getJsonObject().get("_scroll_id")
                    .getAsString();
        } else {
            jestResult = scrollResult(jestClient, indexName, typeName,
                    scrollId);
            scrollId = jestResult.getJsonObject().get("_scroll_id")
                    .getAsString();
        }
        List<T> list = jestResult.getSourceAsObjectList(clazz, true);
        Map<String, Object> map = new HashMap<>();
        map.put("scrollId", scrollId);
        map.put("list", list);
        return map;
    }

    public JestResult searchAfter(JestClient jestClient, String indexName,
                                  String typeName, SearchSourceBuilder searchSource, Object[] sorts)
            throws IOException {
        if (sorts != null) {
            searchSource.searchAfter(sorts);
        }
        JestResult jestResult = scrollSearch(jestClient, indexName, typeName,
                searchSource.toString());
        return jestResult;
    }

    /**
     * 并行分片滚动查询，相当于把scroll查询结果分割成max个部分，这些部分各自生成一个scrollId进行scroll查询。
     *
     * @param jestClient   Jest客户端
     * @param indexName    索引
     * @param typeName     类型
     * @param searchSource SearchSourceBuilder对象
     * @param id           分片下标，最小为0，最大为max-1。
     * @param max          分片数量
     * @return JestResult
     */
    public JestResult slice(JestClient jestClient, String indexName,
                            String typeName, SearchSourceBuilder searchSource, int id, int max)
            throws IOException {
        SliceBuilder sliceBuilder = new SliceBuilder(id, max);
        searchSource.slice(sliceBuilder);
        JestResult jestResult = scrollSearch(jestClient, indexName, typeName,
                searchSource.toString());
        return jestResult;
    }

    /**
     * 滚动查询
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @return JestResult
     */
    public static JestResult scrollSearch(JestClient jestClient,
                                          String indexName, String typeName, String script) throws IOException {
        Search search = new Search.Builder(script).addIndex(indexName)
                .addType(typeName).setParameter(Parameters.SIZE, 1000)
                .setParameter(Parameters.SCROLL, "10m").build();
        JestResult jestResult = jestClient.execute(search);
        return jestResult;
    }

    /**
     * 滚动查询
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param scrollId   游标ID
     * @return JestResult
     */
    public static JestResult scrollResult(JestClient jestClient,
                                          String indexName, String typeName, String scrollId) throws IOException {
        SearchScroll searchScroll = new SearchScroll.Builder(scrollId, "10m")
                .build();
        JestResult jestResult = jestClient.execute(searchScroll);
        return jestResult;
    }

    /**
     * 检索，并处理。
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     * @return
     */
    public static <T> int single(JestClient jestClient, String indexName,
                                 String typeName, String script, Consumer<List<T>> function,
                                 Class<T> clazz) throws IOException {
        // 获取search语句
        String searchQuery = String.format(script, "");
        // 设置search属性
        Search search = new Search.Builder(searchQuery).addIndex(indexName)
                .addType(typeName).build();
        // 发起请求
        JestResult jestResult = jestClient.execute(search);
        // 获取检索结果
        List<T> hits = jestResult.getSourceAsObjectList(clazz, true);
        // 处理结果
        function.accept(hits);
        return hits.size();
    }

    /**
     * 遍历检索结果，并处理。
     *
     * @param jestClient  Jest客户端
     * @param indexName   索引
     * @param typeName    类型
     * @param script      检索语句
     * @param searchAfter 上次检索位置
     * @param size        每次数量
     * @param function    集合处理函数
     * @param clazz       数据类型
     */
    public static <T, L> boolean after(JestClient jestClient, String indexName,
                                       String typeName, String script, String searchAfter, final long size,
                                       Predicate<List<Hit<T, Void>>> function, Class<T> clazz)
            throws IOException {
        String sizeQuery = "\"size\":" + size + ",";
        String searchAfterQuery = searchAfter != null ? searchAfter : "";
        LOGGER.info("遍历开始");
        while (true) {
            // 获取search语句
            String searchQuery = String.format(script,
                    sizeQuery + searchAfterQuery);
            // 设置search属性
            Search search = new Search.Builder(searchQuery).addIndex(indexName)
                    .addType(typeName).build();
            // 发起请求
            SearchResult searchResult = jestClient.execute(search);
            // 获取检索结果
            List<Hit<T, Void>> hits = searchResult.getHits(clazz);
            if (hits.isEmpty()) {
                break;
            }
            List<String> sorts = hits.get(hits.size() - 1).sort;
            searchAfterQuery = "\"search_after\":[\""
                    + String.join("\",\"", sorts) + "\"],";
            boolean test = function.test(hits);
            if (!test) {
                return false;
            }
            // 当起始条数超过总数时跳出循环
        }
        LOGGER.info("遍历结束");
        return true;
    }

    /**
     * 遍历检索结果，并处理。
     *
     * @param jestClient  Jest客户端
     * @param indexName   索引
     * @param typeName    类型
     * @param script      检索语句
     * @param searchAfter 上次检索位置
     * @param function    集合处理函数
     * @param clazz       数据类型
     */
    public static <T, L> boolean after(JestClient jestClient, String indexName,
                                       String typeName, String script, String searchAfter,
                                       Predicate<List<Hit<T, Void>>> function, Class<T> clazz)
            throws IOException {
        return after(jestClient, indexName, typeName, script, searchAfter,
                1000L, function, clazz);
    }

    private static Integer MAX_THREAD_NUM = 1;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(MAX_THREAD_NUM);

    public static JestClient jestClient() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(
                new HttpClientConfig.Builder("http://20.0.0.100:9200")
                        .multiThreaded(true)
                        .defaultMaxTotalConnectionPerRoute(20)
                        .readTimeout(1000 * 60 * 5)
                        .maxTotalConnection(100)
                        .build());
        return factory.getObject();
    }


    public static void main(String[] args) throws IOException {
        JestClient client = jestClient();

       /* String script = "{\n" +
                "  \"query\": {\n" +
                "    \"range\": {\n" +
                "      \"url_id\": {\n" +
                "        \"gte\": 1,\n" +
                "        \"lte\": 100\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"size\": 1000\n" +
                "}";*/

        String script = "{\n" +
                "  \"query\": {\n" +
                "    \"range\": {\n" +
                "      \"url_id\": {\n" +
                "        \"gte\": 1,\n" +
                "        \"lte\": 100000000\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"sort\": [\n" +
                "    {\n" +
                "      \"url_id\": {\n" +
                "        \"order\": \"asc\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
      //  scroll(client, "zfcg_71@spider_2020", "_doc", script, null, CNGovDataEsExample.class);
     //   search(client, "zfcg_71@spider_2020", "_doc", script, null, CNGovDataEsExample.class);
        long l = System.currentTimeMillis();
        SearchResult searchResult = rangeSearch(100000, 200000, "url_id", "zfcg_71@spider_2020", "_doc", client);

        List<Hit<CNGovDataEsExample, Void>> hits = searchResult.getHits(CNGovDataEsExample.class);

        long l1 = System.currentTimeMillis();

        long l2 = l1 - l;
        double v = l2 / 1000.00;
        System.out.println(v + " s");
        System.out.println(hits.size());
        System.out.println("total" + searchResult.getTotal());
    }

    /**
     * 遍历检索结果，并处理。
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     */

    public static <T> boolean scroll(JestClient jestClient, String indexName,
                                     String typeName, String script, Predicate<List<T>> function,
                                     Class<T> clazz) throws IOException {
        // 每次遍历数量
        final long size = 3000L;
        // elasticsearch遍历查询scrollId
        String scrollId = null;
        // 总数
        long total = 0L;
        // 完成
        long finish = 0L;
        LOGGER.info("遍历开始");
        while (true) {
            // 检索结果
            JestResult jestResult = null;
            if (scrollId == null) {
                // 当scrollId不存在时，即第一次遍历。
                // 获取search语句
                String searchQuery = String.format(script, "");
                // 设置search属性
                Search search = new Search.Builder(searchQuery)
                        .addIndex(indexName).addType(typeName)
                        .setParameter(Parameters.SIZE, size)
                        .setParameter(Parameters.SCROLL, TimeValue.timeValueMinutes(10))
                        .setHeader("Connection", "Keep-Alive").build();
                // 发起请求
                jestResult = jestClient.execute(search);
                // 获得scrollId
                scrollId = jestResult.getJsonObject().get("_scroll_id")
                        .getAsString();
                // 获得总数
                total = jestResult.getJsonObject().get("hits").getAsJsonObject()
                        .get("total").getAsLong();
            } else {
                // 设置scroll属性
                SearchScroll searchScroll = new SearchScroll.Builder(scrollId,
                        "20m").build();
                // 发起请求
                jestResult = jestClient.execute(searchScroll);
                // 获得scrollId
                scrollId = jestResult.getJsonObject().get("_scroll_id")
                        .getAsString();
            }
            // 获取检索结果
            List<T> hits = jestResult.getSourceAsObjectList(clazz, true);

            /*if ( hits == null || hits.size() < 1){
                break;
            }*/

            if (hits.isEmpty()) {
                break;
            }

            String sqlStr = getSqlStr(hits);

            EXECUTOR.execute(new CleanEsCNGovTask(sqlStr, hits));




           /* for (T data : hits) {
                CNGovDataEsExample data1 = (CNGovDataEsExample) data;





                //   System.err.println(data1.getUrl_id());

            }*/


            /*boolean test = function.test(hits);
            if (!test) {
                return false;
            }*/
            finish += hits.size();

            DecimalFormat df = new DecimalFormat("0.00");
            String format = df.format(((float) finish / total) * 100);
            //  LOGGER.info("has finished: " + format + "% "+finish+"/"+total);
            LOGGER.info("处理进度 [{}/{},{}%]", finish, total, format);
            // 当起始条数超过总数时跳出循环
        }
        ClearScroll clearScroll = new ClearScroll.Builder()
                .addScrollId(scrollId).build();
        JestResult jestResult = jestClient.execute(clearScroll);
        // 获取成功状态
        boolean succeeded = jestResult.isSucceeded();
        LOGGER.info("清除scrollId {}", succeeded ? "成功" : "失败");
        LOGGER.info("遍历结束");
        return true;
    }

    public static String getSqlStr(List list) {
        StringBuilder sb = new StringBuilder("select * from spider_71_ggzy_zgzfcgw_url where url_id in (");

        for (Object data : list) {
            CNGovDataEsExample dataEsExample = (CNGovDataEsExample) data;
            sb.append(dataEsExample.getUrl_id()).append(",");
        }

        return sb.delete(sb.length() - 1, sb.length()).append(")").toString();
    }


    /**
     * 遍历检索结果，并处理。
     *
     * @param jestClient Jest客户端
     * @param indexName  索引
     * @param typeName   类型
     * @param script     检索语句
     * @param function   集合处理函数
     * @param clazz      数据类型
     */
    @Deprecated
    public static <T, L> boolean page(JestClient jestClient, String indexName,
                                      String typeName, String script, Predicate<List<T>> function,
                                      Class<T> clazz) throws IOException {
        // 每次遍历数量
        final long size = 1000L;
        // 获取count语句
        String countQuery = String.format(script, "");
        // 设置count属性
        Count count = new Count.Builder().addIndex(indexName).addType(typeName)
                .query(countQuery).build();
        // 发起请求
        CountResult results = jestClient.execute(count);
        // 总数
        final long total = results.getCount().intValue();
        // 完成
        long finish = 0L;
        // 从第几条开始
        long from = 0;
        LOGGER.info("遍历开始");
        while (from < total) {
            // 获取search语句
            String searchQuery = String.format(script,
                    "\"from\":" + from + ",\"size\":" + size
                            + ",\"sort\":[{\"_id\":{\"order\":\"asc\"}}],");
            // 设置search属性
            Search search = new Search.Builder(searchQuery).addIndex(indexName)
                    .addType(typeName).build();
            // 发起请求
            JestResult jestResult = jestClient.execute(search);
            // 获取检索结果
            List<T> hits = jestResult.getSourceAsObjectList(clazz, true);
            boolean test = function.test(hits);
            if (!test) {
                return false;
            }
            finish += hits.size();
            LOGGER.info("遍历进度 [{}/{}]", finish, total);
            // 修改起始条数
            from += size;
        }
        LOGGER.info("遍历结束");
        return true;
    }

    /**
     * 遍历集合，并处理。
     *
     * @param list     数据集合
     * @param function 处理函数
     */
    public static <T> boolean iterator(List<T> list,
                                       Predicate<List<T>> function, final long size) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        // 若集合不为空
        // 获取遍历器
        Iterator<T> iterator = list.iterator();
        // 待处理数量
        long total = list.size();
        LOGGER.info("处理开始，待处理[{}]条", total);
        do {
            // 获取循环次数
            long forSize = total < size ? total : size;
            // 添加处理数据
            List<T> group = new ArrayList<>();
            for (long i = 0; i < forSize; i++) {
                T next = iterator.next();
                group.add(next);
            }
            // 业务处理
            boolean test = function.test(group);
            if (!test) {
                LOGGER.info("处理失败");
                return false;
            }
            // 剩余数量减少
            total -= forSize;
            // 当待导入数量为0时跳出循环
        } while (total > 0);
        list.clear();
        LOGGER.info("处理结束");
        return true;
    }

    /**
     * 遍历集合，并处理。
     *
     * @param list     数据集合
     * @param function 处理函数
     */
    public static <T> boolean iterator(List<T> list,
                                       Predicate<List<T>> function) {
        return iterator(list, function, 1000L);
    }

    /**
     * 多字段查询
     *
     * @param fields 字段
     * @return BoolQueryBuilder
     */
    public static BoolQueryBuilder searchWithFields(String stringQuery,
                                                    Operator operator, String... fields) {
        if (stringQuery == null) {
            return null;
        }
        final String regex = "[\\pP\\p{Punct}￥ ]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(stringQuery);
        stringQuery = m.replaceAll(" ").trim().replaceAll("\\s+", " ");
        if (stringQuery.isEmpty()) {
            return null;
        }
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        String[] words = stringQuery.split(" ");
        for (String word : words) {
            String regexp = "*" + word + "*";
            BoolQueryBuilder itemQuery = QueryBuilders.boolQuery()
                    .minimumShouldMatch(1);
            for (String str : fields) {
//                RegexpQueryBuilder fieldRegexpQuery = QueryBuilders
//                    .regexpQuery(str, regexp);
//                RegexpQueryBuilder keywordRegexpQuery = QueryBuilders
//                    .regexpQuery(str + ".keyword", regexp);
                WildcardQueryBuilder fieldWildcardQuery = QueryBuilders
                        .wildcardQuery(str, regexp);
                WildcardQueryBuilder keywordWildcardQuery = QueryBuilders
                        .wildcardQuery(str + ".keyword", regexp);
                MatchQueryBuilder matchQuery = QueryBuilders
                        .matchQuery(str, word).operator(operator);
                MatchQueryBuilder ansjMatchQuery = QueryBuilders
                        .matchQuery(str + ".ansj", word).operator(operator);
                MatchQueryBuilder whitespacematchQuery = QueryBuilders
                        .matchQuery(str + ".whitespace", word).operator(operator);
                QueryBuilder queryBuilder = QueryBuilders.disMaxQuery()
//                    .add(fieldRegexpQuery).add(keywordRegexpQuery)
                        .add(fieldWildcardQuery).add(keywordWildcardQuery)
                        .add(matchQuery).add(ansjMatchQuery)
                        .add(whitespacematchQuery);
                itemQuery.should(queryBuilder);
            }
            boolQuery.must(itemQuery);
        }
        return boolQuery;
    }

    /**
     * 多字段查询
     *
     * @param fields 字段
     * @param word   词
     * @return BoolQueryBuilder
     */
    public static BoolQueryBuilder searchWithFields(String word,
                                                    String... fields) {
        return ElasticSearchUtils.searchWithFields(word, Operator.AND, fields);
    }

    /**
     * 添加检索黑名单
     *
     * @param query  BoolQuery
     * @param fields 检索字段
     * @param list   黑名单词
     */
    public static void blacklist(BoolQueryBuilder query, String[] fields,
                                 String... list) {
        if (fields.length < 1 || list.length < 1) {
            return;
        }
        BoolQueryBuilder blacklist = QueryBuilders.boolQuery();
        for (String black : list) {
            BoolQueryBuilder blackQuery = searchWithFields(black, fields);
            if (blackQuery != null) {
                blacklist.mustNot(blackQuery);
            }
        }
        query.filter(blacklist);
    }


    public static SearchResult rangeSearch(int gte, int let, String filed, String indexName, String typeName, JestClient jestClient) throws IOException {

        //   SearchRequest request = new SearchRequestBuilder();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        RangeQueryBuilder query = new RangeQueryBuilder("url_id");
        query.gte(gte);
        query.lte(let);

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        String s = sourceBuilder.query(query).size(10000).toString();
        System.out.println(s);

        Search search = new Search.Builder(s).addIndex(indexName)
                .addType(typeName).build();
        SearchResult searchResult = jestClient.execute(search);
        String jsonString = searchResult.getJsonString();
   //     System.err.println(jsonString);
        return searchResult;

       /* //构建搜索对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //filter
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("skuName","小米");
        boolQueryBuilder.filter(termQueryBuilder);

        //must
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("skuDesc","移动联通电信4G手机");
        boolQueryBuilder.must(matchQueryBuilder);
        searchSourceBuilder.query(boolQueryBuilder);
        //分页
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(20);
        //高亮
        SearchSourceBuilder.highlight();
        String dslStr = searchSourceBuilder.toString();
        Search search = new Search.Builder(dslStr).addIndex("bookindex").addType("PmsSkuInfo").build();
        SearchResult result = jestClient.execute(search);*/

    }

}
