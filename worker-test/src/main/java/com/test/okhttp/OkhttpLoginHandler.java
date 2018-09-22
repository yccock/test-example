package com.test.okhttp;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("classpath:common.properties")
public class OkhttpLoginHandler {

    private static final Logger logger = LoggerFactory.getLogger(OkhttpLoginHandler.class);

    @Value("${connect.timeout}")
    private Integer connectTimeout;

    @Value("${read.timeout}")
    private Integer readTimeout;

    @Value("${write.timeout}")
    private Integer writeTimeout;

    @Value("${follow.redirect}")
    private Boolean isFollowRedirect;

    @Value("${login.url}")
    private String loginUrl;

    @Value("${login.username}")
    private String username;

    @Value("${login.password}")
    private String password;

    @Bean
    public OkHttpClient okHttpClient() throws MalformedURLException {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .followRedirects(isFollowRedirect)
                .cookieJar(new CookieJar() {
                    URL url = new URL(loginUrl);
                    String loginCookie = url.getHost();
                    //这里可以做cookie传递，保存操作
                    Map<String, List<Cookie>> cookieMap = new HashMap<String, List<Cookie>>();
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        if (httpUrl.host().equals(loginCookie)) {
                            cookieMap.put(httpUrl.host(), list);
                        }
                    }

                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        List<Cookie> cookies = cookieMap.get(loginCookie);
                        return cookies == null ? new ArrayList<Cookie>() : cookies;
                    }
                })
                .addInterceptor(new LoginCheckInterceptor())
                .build();
        return okHttpClient;
    }

    @Bean
    public Request.Builder requestBuilder(){
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        builder.addHeader("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        builder.addHeader("Cache-Control", "max-age=0");
        builder.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
        builder.addHeader("Connection", "keep-alive");
        return builder;
    }

    class LoginCheckInterceptor implements Interceptor {
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            if (response.isRedirect()) {
                logger.warn("login context has been invalid, relogin again");
                FormBody formBody = new FormBody.Builder()
                        .add("username", username)
                        .add("password", password)
                        .build();
                Request loginReq = new Request.Builder()
                        .url(loginUrl)
                        .post(formBody)
                        .build();
                chain.proceed(loginReq);
                //重新请求
                response = chain.proceed(request);
                if (response.isRedirect()) {
                    logger.error("retry login failed, code:{}", response.code());
                }
            }
            return response;
        }
    }
}
