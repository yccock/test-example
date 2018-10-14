package com.test.quartz._2JobDataMap.demo2;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String message = jobDataMap.getString("message");
        System.out.println("===================================");
        //从JobDetail中获取JobDataMap的值
        System.out.println("job传递的参数：" + message);
        System.out.println();

        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        String message1 = jobDataMap1.getString("message");
        System.out.println("trigger传递的参数：" + message1);
        System.out.println();

        System.out.println("开始任务：" + sdf.format(new Date()));
        System.out.println("===================================");
    }
}
