package com.test.okhttp;

import com.google.gson.Gson;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkhttpUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(OkhttpUtil.class);

    private static Gson gson = new Gson();

    public enum ContentType{
        FORM("application/x-www-form-urlencoded"),
        FILE("multipart/form-data"),
        XML("application/xml"),
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

    public static Response get(String url) throws IOException {
        return get(url, null);
    }

    public static Response get(String url, Map<String, Object> headers) throws IOException {
        return sendRequest(url, null, headers, HttpMethod.GET, ContentType.FORM);
    }

    public static Response post(String url, Map<String, Object> datas, ContentType contentType) throws IOException {
        return post(url, datas, null, contentType);
    }

    public static Response post(String url, Map<String, Object> datas, Map<String, Object> headers,
                                ContentType contentType) throws IOException {
        return sendRequest(url, datas, headers, HttpMethod.POST, contentType);
    }

    private static Response sendRequest(String url, Map<String, Object> datas, Map<String, Object> headers,
                                        HttpMethod httpMethod, ContentType contentType) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(6, TimeUnit.SECONDS)
                .readTimeout(6, TimeUnit.SECONDS)
                .writeTimeout(6, TimeUnit.SECONDS)
                .followRedirects(false)
                .build();
        Request.Builder requestBuilder = new Request.Builder();
        if (headers != null) {
            for (Map.Entry<String, Object> entrySet : headers.entrySet()) {
                requestBuilder.header(entrySet.getKey(), entrySet.getValue().toString());
            }
        }
        RequestBody requestBody = null;
        if (ContentType.FORM.equals(contentType)) {
            FormBody.Builder formBody = new FormBody.Builder();
            if (datas != null) {
                for (Map.Entry<String, Object> entry : datas.entrySet()) {
                    formBody.add(entry.getKey(), entry.getValue().toString());
                }
            }
            requestBody = formBody.build();
        } else if (ContentType.JSON.equals(contentType)){
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            requestBody = RequestBody.create(mediaType, gson.toJson(datas));
        } else if (ContentType.XML.equals(contentType)){
            MediaType mediaType = MediaType.parse("text/xml;charset=UTF-8");
            requestBody = RequestBody.create(mediaType, gson.toJson(datas));
        }
        Request request;
        switch (httpMethod) {
            case POST:
                request = requestBuilder.url(url).post(requestBody).build();
                break;
            default:
                request = requestBuilder.url(url).get().build();
        }
        return okHttpClient.newCall(request).execute();
    }
}
