package com.test.httpclient;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtilTest {

    @Test
    public void get_test() throws IOException {
        HttpResponse response = HttpClientUtil.get("http://www.baidu.com");
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(response.getEntity().getContentType());
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

    @Test
    public void post_test() throws IOException {
        Map<String, Object> datas = new HashMap<>();
        datas.put("username", "u");
        datas.put("password", "p");
        HttpResponse response = HttpClientUtil.post("https://test.com", datas, HttpClientUtil.ContentType.FORM);
        System.out.println(response.getStatusLine().getStatusCode());
        System.out.println(IOUtils.toString(response.getEntity().getContent(), "utf-8"));
        System.out.println(EntityUtils.toString(response.getEntity()));
        for (Header header : response.getAllHeaders()) {
            if (header.getName().equals("Expires")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(header.getName() + ": " + sdf.format(new Date(header.getValue())));
            } else {
                System.out.println(header.getName() + ": " +header.getValue());
            }
        }
    }
}
