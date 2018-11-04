package com.test.elasticsearch;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ESUtil {

    private static final Logger logger = LoggerFactory.getLogger(ESUtil.class);

    private JestClient jestClient;

    public ESUtil(String serverUri) {
        this.jestClient = initJestClient(serverUri);
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
     * 创建索引
     * @param index
     * @return
     */
    public boolean createIndex(String index) {
        try {
            JestResult jestResult = jestClient.execute(new CreateIndex.Builder(index).build());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public boolean deleteIndex(String index) {
        try {
            JestResult jestResult = jestClient.execute(new DeleteIndex.Builder(index).build());
            return jestResult.isSucceeded();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    public void search(String serverUri, String indexName, String typeName, String query){
        Search search = new Search.Builder("").addIndex(indexName).addType(typeName).build();
        try {
            SearchResult result = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverUril = "http://192.168.172.53:9200";
        String indexName = "monitor_2";
        String typeName = "data_source";
        String query = "_search";
        ESUtil esUtil = new ESUtil(serverUril);
        esUtil.search(serverUril, indexName, typeName, query);
    }
}
