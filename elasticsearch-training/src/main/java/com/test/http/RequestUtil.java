package com.test.http;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RequestUtil {
    private RestTemplate restTemplate = new RestTemplate();

    public RequestUtil() {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));

        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        jackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

        List<HttpMessageConverter<?>> msgConverters = new ArrayList<HttpMessageConverter<?>>();
        msgConverters.add(stringHttpMessageConverter);
        msgConverters.add(jackson2HttpMessageConverter);
        restTemplate.setMessageConverters(msgConverters);
    }

    public void deleteByQuery(String url, HashMap<String, Object> urlVariables) {
        this.restTemplate.delete(url, urlVariables);
    }

    public void deleteByQuery(String url) {
        this.restTemplate.delete(url);
    }

    public <T> T getForObject(String url, Class<T> clazz) {
        return this.restTemplate.getForObject(url, clazz);
    }

    public HashMap getForObject(String url) {
        return this.restTemplate.getForObject(url, HashMap.class);
    }

    public <T> T postForObject(String url, Object requestBody, Class<T> responseType) {
        return this.restTemplate.postForObject(url, requestBody, responseType);
    }

    public synchronized HashMap postForObject(String url, Object requestBody) {
        return this.restTemplate.postForObject(url, requestBody, HashMap.class);
    }


    public static void main(String[] args) {
        RequestUtil requestUtil = new RequestUtil();
        System.out.println(requestUtil.getForObject("http://localhost:8080/json"));
    }
}
