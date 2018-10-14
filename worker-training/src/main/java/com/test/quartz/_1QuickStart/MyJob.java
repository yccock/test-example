package com.test.quartz._1QuickStart;

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
        //获取JobDetail内容
        System.out.println("job名称：" + jobKey.getName());
        System.out.println("job组名：" + jobKey.getGroup());
        System.out.println("job类名：" + jobExecutionContext.getJobDetail().getJobClass().getName());
        System.out.println();

        //获取Trigger内容
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger名称：" + triggerKey.getName());
        System.out.println("trigger组名：" + triggerKey.getGroup());
        System.out.println();

        //其他
        System.out.println("当前任务执行时间：" + sdf.format(jobExecutionContext.getFireTime()));
        System.out.println("下次任务执行时间：" + sdf.format(jobExecutionContext.getNextFireTime()));
        System.out.println();

        System.out.println("开始任务：" + sdf.format(new Date()));
        System.out.println("===================================");
    }
}
