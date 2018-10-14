package com.test.quartz._4trigger.CronTrigger;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob implements Job {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===================================");

        //获取Trigger内容
        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println("job名称：" + trigger.getJobKey().getName());
        System.out.println("job组名：" + trigger.getJobKey().getGroup());
        System.out.println();
        System.out.println("开始任务：" + sdf.format(new Date()));
        System.out.println("===================================");
    }
}
