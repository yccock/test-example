package com.test.httpclient;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class HttpClientUtil {

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

    public static Map<String, Object> castToMap(String str){
        Map<String, Object> map = new HashMap<>();
        return gson.fromJson(str, map.getClass());
    }

//    public static HttpResponse get(String url){
//
//    }
//
//    private static HttpResponse sendRequest(String url, Map<String, Object> datas,
//                                            Map<String, Object> headers){
//        HttpClients.custom().addInterceptorLast(new HttpRequestInterceptor() {
//            @Override
//            public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
//
//            }
//        })
//    }
}
