package com.test.quartz._6listener.jobListener;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 每次调度器执行 Job，它会在调用 execute(…) 方法前创建一个新的 Job 实例。当执行完成后，
 * 所有 Job 的引用将会丢弃，这些对象会被垃圾回收
 */
public class MyJob implements Job {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("===================================");

        System.out.println("开始任务：" + sdf.format(new Date()));
        System.out.println("===================================");
    }
}
