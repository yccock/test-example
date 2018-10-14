package com.test.quartz._4trigger.SimpleTrigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

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
        System.out.println("任务开始时间：" + sdf.format(trigger.getStartTime()));
        System.out.println("任务结束时间：" + sdf.format(trigger.getEndTime()));

        System.out.println("开始任务：" + sdf.format(new Date()));
        System.out.println("===================================");
    }
}
