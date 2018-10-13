package com.test.worker.api;

import com.test.worker.domain.MyTest;
import com.test.worker.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorTask extends Task<MyTest> {

    public final static Logger logger = LoggerFactory.getLogger(MonitorTask.class);

    private ExecutorService executorService = new ThreadPoolExecutor(5,
            10, 0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1000),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public MonitorTask(MyTest myTest) {
        super(myTest);
    }

    /**
     * 具体的任务执行入口
     */
    public void startTask() {
        logger.info("======start MonitorTask");
        //startMyDataCollector(executorService);
    }

    public void stopTask() {
        logger.info("======stop MonitorTask");
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
        try {
            executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!executorService.isShutdown() || !executorService.isTerminated()) {
            executorService.shutdownNow();
        }
        if (executorService.shutdownNow().size() > 0) {
            logger.error("shutdown MonitorTask failed");
        }
    }
}
