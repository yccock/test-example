package com.test.elasticsearch;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.*;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class EsClient {

    private static final Logger logger = LoggerFactory.getLogger(EsClient.class);

    private JestClient jestClient;

    private String indexName;

    private String typeName;

    public EsClient(String serverUri, String indexName, String typeName) {
        this.jestClient = initJestClient(serverUri);
        this.indexName = indexName;
        this.typeName = typeName;
    }

    public JestClient initJestClient(String serverUri){
        HttpClientConfig clientConfig = new HttpClientConfig
                .Builder(serverUri)
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create())
                .readTimeout(10000)
                .multiThreaded(true)
                .defaultMaxTotalConnectionPerRoute(2)
                .maxTotalConnection(10)
                .build();
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(clientConfig);
        return factory.getObject();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public JestResult searchById(long id){
        JestResult result = null;
        try {
            Get build = new Get.Builder(indexName, String.valueOf(id))
                    .index(indexName)
                    .type(typeName)
                    .build();
            result = jestClient.execute(build);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }


    /**
     * 根据queryString查询
     * @param queryString
     */
    public JestResult searchByQueryString( String queryString){
        JestResult result = null;
        try {
            Search search = new Search.Builder(queryString).addIndex(indexName).addType(typeName).build();
            result = jestClient.execute(search);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public JestResult updateDocument(String script ,  String id) {
        /*String script = "{" +
                "    \"doc\" : {" +
                "        \"title\" : \""+article.getTitle()+"\"," +
                "        \"content\" : \""+article.getContent()+"\"," +
                "        \"author\" : \""+article.getAuthor()+"\"," +
                "        \"source\" : \""+article.getSource()+"\"," +
                "        \"url\" : \""+article.getUrl()+"\"," +
                "        \"pubdate\" : \""+new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(article.getPubdate())+"\"" +
                "    }" +
                "}";*/
        Update update = new Update.Builder(script).index(indexName).type(typeName).id(id).build();
        JestResult result = null ;
        try {
            result = jestClient.execute(update);
            logger.info("updateDocument == " + result.getJsonString());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result ;
    }
    /**
     * 根据id删除数据
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteDocumentById(Long id) {
        boolean succeeded = false;
        try {
            Delete build = new Delete.Builder(String.valueOf(id))
                    .index(indexName)
                    .type(typeName)
                    .build();
            JestResult result = jestClient.execute(build);
            succeeded = result.isSucceeded();
            if (!succeeded) {
                logger.error("delete failed, error:", result.getErrorMessage());
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return succeeded;
    }

    public JestResult deleteDocumentByQuery(String queryString) {
        JestResult result = null ;
        try {
            DeleteByQuery build = new DeleteByQuery.Builder(queryString)
                    .addIndex(indexName)
                    .addType(typeName)
                    .build();
            result = jestClient.execute(build);
            logger.info("deleteDocument == " + result.getJsonString());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    public void closeJestClient(JestClient jestClient) throws Exception {
        if (jestClient != null) {
            jestClient.close();
        }
    }

    public void insert(T t) {
        Index index = new Index.Builder(t).index(indexName).type(typeName).build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void bulkIsert(List<T> list) {
        if (list.size() == 0) {
            return;
        }
        List<Index> indexList = list.stream()
                .map(t -> new Index.Builder(t).build())
                .collect(Collectors.toList());
        Bulk bulk = new Bulk.Builder()
                .defaultIndex(indexName)
                .defaultType(typeName)
                .addAction(indexList)
                .build();
        try {
            BulkResult result = jestClient.execute(bulk);
            if (!result.isSucceeded()) {
                logger.error("write to es error, response code:{}, error info:{}",
                        result.getResponseCode(), result.getErrorMessage());
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws Exception {
        // String serverUril = "http://192.168.172.53:9200";
        // String indexName = "monitor_2";
        // String typeName = "data_source";
        // String query = "_search";
        // EsClient esClient = new EsClient(serverUril);
        // esClient.search(serverUril, indexName, typeName, query);

        String serverUril = "http://127.0.0.1:9200";
        String indexName = "test_index";
        String typeName = "test_type";
        String query = "_search";
        EsClient esClient = new EsClient(serverUril, indexName, typeName);
        JestResult result = esClient.searchById(1);
        System.out.println(result.getJsonObject().getAsJsonObject("_source"));
    }
}
