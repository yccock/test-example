package com.test.okhttp;

import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OkhttpUtilTest {

    @Test
    public void get_test() throws IOException {
        Response response = OkhttpUtil.get("http://www.baidu.com");
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    @Test
    public void post_test() throws IOException {
        Map<String, Object> datas = new HashMap<>();
        datas.put("username", "u");
        datas.put("password", "p");
        Response response = OkhttpUtil.post("https://test.com", datas, OkhttpUtil.ContentType.FORM);
        System.out.println(response.code());
        System.out.println(response.body().string());
        System.out.println(response.headers());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Expires:" + sdf.format(new Date(response.header("Expires"))));
        System.out.println("cookie:" + response.headers("Set-Cookie"));
    }
}
