package com.test.httpclient;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.cnblogs.com/codingexperience/p/5319850.html
//https://github.com/Arronlong/httpclientutil
public class HttpClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);
    private static Gson gson = new Gson();

    public enum ContentType{
        FORM("application/x-www-form-urlencoded"),
        FILE("multipart/form-data"),
        JSON("application/json");

        private String value;

        ContentType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum HttpMethod{
        GET,POST
    }

    public static Map<String, Object> castStringToMap(String str){
        Map<String, Object> map = new HashMap<>();
        return gson.fromJson(str, map.getClass());
    }

    public static HttpResponse get(String url) throws IOException {
        return get(url, null);
    }

    public static HttpResponse get(String url, Map<String, Object> headers) throws IOException {
        return get(url, headers, null);
    }

    public static HttpResponse get(String url, Map<String, Object> headers,
                                            HttpClientConnectionManager connectionManager) throws IOException {
        return sendRequest(url, null, headers, HttpMethod.GET, ContentType.FORM, HttpVersion.HTTP_1_1, connectionManager);
    }

    public static HttpResponse post(String url, Map<String, Object> datas, ContentType contentType) throws IOException {
        return post(url, datas,null, contentType);
    }

    public static HttpResponse post(String url, Map<String, Object> datas, Map<String, Object> headers, ContentType contentType) throws IOException {
        return post(url, datas, headers, contentType,null);
    }

    public static HttpResponse post(String url, Map<String, Object> datas, Map<String, Object> headers, ContentType contentType,
                                    HttpClientConnectionManager connectionManager) throws IOException {
        return sendRequest(url, datas, headers, HttpMethod.POST, contentType, HttpVersion.HTTP_1_1, connectionManager);
    }

    private static HttpResponse sendRequest(String url, Map<String, Object> datas, Map<String, Object> headers, HttpMethod httpMethod,
                                            ContentType contentType, HttpVersion httpVersion,
                                            HttpClientConnectionManager connectionManager) throws IOException {
        URI uri;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid url ..");
        }
        HttpUriRequest httpUriRequest = buildHttpUriRequest(uri, httpMethod, httpVersion, contentType, datas, headers);
        if (headers != null) {
            for (Map.Entry<String, Object> item : headers.entrySet()) {
                httpUriRequest.setHeader(item.getKey(), item.getValue().toString());
            }
        }

        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        if (connectionManager != null) {
            httpClientBuilder.setConnectionManager(connectionManager);
        }
        if (url.startsWith("https")) {
            try {

                TrustManager[] tm = new TrustManager[]{new X509TrustManager() {
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType)
                            throws CertificateException {
                    }
                }};

                SSLContext sslContext = SSLContext.getInstance("SSL");

                sslContext.init(null, tm, new SecureRandom());

                httpClientBuilder.setSslcontext(sslContext).setHostnameVerifier(new AllowAllHostnameVerifier());
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
            }
        }
        return httpClientBuilder.build().execute(httpUriRequest);
    }

    private static HttpUriRequest buildHttpUriRequest(URI uri, HttpMethod httpMethod, HttpVersion httpVersion, ContentType contentType,
                                               Map<String, Object> datas, Map<String, Object> headers) {
        HttpUriRequest httpUriRequest;
        HttpEntity httpEntity = null;
        if (datas != null) {
            if (ContentType.FORM.equals(contentType)) {
                httpEntity = buildFormBody(datas);
            } else if (ContentType.JSON.equals(contentType)) {
                httpEntity = buildJsonBody(datas);
            }
        }
        switch (httpMethod) {
            case POST:
                HttpPost httpPost = new HttpPost(uri);
                httpPost.setProtocolVersion(httpVersion);
                httpPost.setEntity(httpEntity);
                httpUriRequest = httpPost;
                break;
            default:
                HttpGet httpGet = new HttpGet(uri);
                httpGet.setProtocolVersion(httpVersion);
                httpUriRequest = httpGet;
        }
        return httpUriRequest;
    }

    private static HttpEntity buildFormBody(Map<String, Object> datas) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry<String, Object> entry : datas.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
        }
        try {
            return new UrlEncodedFormEntity(nameValuePairs, "utf-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }

    private static HttpEntity buildJsonBody(Map<String, Object> datas) {
        try {
            return new StringEntity(gson.toJson(datas));
        } catch (UnsupportedEncodingException e) {
            LOGGER.info(e.getMessage());
            return null;
        }
    }
}
