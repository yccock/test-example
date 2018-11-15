package com.test.jenkins;

import com.test.okhttp.OkhttpUtil;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

// https://my.oschina.net/sanpeterguo/blog/197931
// https://www.cnblogs.com/zjsupermanblog/archive/2017/07/26/7238422.html
// https://testerhome.com/topics/6057
// https://github.com/jenkinsci/java-client-api
// http://orchome.com/734
public class JenkinsHttpApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(JenkinsHttpApi.class);

    public static Map<String, Object> headerMap = new HashMap<>();

    public static final String SERVER_URL = "http://192.168.202.132/jenkins";

    static {
        headerMap.put("Authorization", "Basic " + Base64.getUrlEncoder().encodeToString("admin:12345".getBytes()));
    }

    public static boolean createJob(String jobName, String jobXml){
        try {
            Response response = OkhttpUtil.post(SERVER_URL + "/createItem?name=" + jobName, null, headerMap, OkhttpUtil.ContentType.XML);
            int code = response.code();
            if ( code != 200) {
                LOGGER.error("response error, code:{}", code);
            }
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            return false;
        }
    }
}
