package com.test.java;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EsBatchInsert {

    private static TransportClient client;
    private static String esIndex;
    private static String esType;

    static {
        try {
            Properties properties = loadFile();
            String clusterName = properties.getProperty("cluster.name");
            String ip = properties.getProperty("es.ip");
            String port = properties.getProperty("es.java.port");
            esIndex = properties.getProperty("es.index");
            esType = properties.getProperty("es.type");
            Settings settings = Settings.settingsBuilder().put("cluster.name", clusterName).build();
            client = TransportClient.builder().settings(settings).build();
            client.addTransportAddress(new InetSocketTransportAddress(
                    InetAddress.getByName(ip),
                    Integer.valueOf(Integer.parseInt(port))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties loadFile() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = EsBatchInsert.class.getClassLoader().getResourceAsStream("es.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }

    public void batchInsert(List<HashMap<String, Object>> bulkList) {
        if (null == bulkList || bulkList.size() == 0) {
            System.out.println("======insert to redis es failed, size: {}" + bulkList.size());
            return;
        }
        int totalRecord = bulkList.size();
        int pageSize = 10000;
        int totalPage = (int) Math.ceil((totalRecord + pageSize - 1) / pageSize);
        for (int i = 0; i < totalPage; i++) {
            BulkRequestBuilder bulkRequest = client.prepareBulk();
            int start = i * pageSize;
            int end;
            if (i == (totalPage - 1)) {
                end = totalRecord;
            } else {
                end = start + pageSize;
            }
            for (int j = start; j < end; j++) {
                bulkRequest.add(client.prepareIndex(esIndex, esType).setSource(bulkList.get(j)));
            }
            bulkRequest.execute().actionGet(2000, TimeUnit.MILLISECONDS);
        }
    }

    public void shutdown() {
        client.close();
    }

    public static void main(String[] args) {
        List<HashMap<String, Object>> maps = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("aa", i);
            maps.add(map);
        }
        EsBatchInsert esUtil = new EsBatchInsert();
        esUtil.batchInsert(maps);
        esUtil.shutdown();
    }
}
