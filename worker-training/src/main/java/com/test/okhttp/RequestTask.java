package com.test.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class RequestTask {

    private static final Logger logger = LoggerFactory.getLogger(RequestTask.class);

    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    Request.Builder requestBuilder;

    CountDownLatch countDownLatch = new CountDownLatch(1);

    ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

    public void start(){
        executor.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                logger.info("start schedule...");
                doGet("http://test.com/instances.json");
            }
        }, 1, 5, TimeUnit.SECONDS);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    public void shutdown(){
        executor.shutdown();
        try {
            executor.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        executor.shutdownNow();
    }

    public String doGet(String url){
        Request request = requestBuilder.url(url).get().build();
        Response response = null;
        String result = "";
        try {
            response = okHttpClient.newCall(request).execute();
            int code = response.code();
            if (code != 200) {
                logger.error("{} failed, response code:{}", url, code);
                return result;
            }
            result = response.body().string();
            logger.info("url:{}, response:{}", url, result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return result;
    }

}
