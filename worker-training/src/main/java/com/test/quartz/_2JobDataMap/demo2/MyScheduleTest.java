package com.test.quartz._2JobDataMap.demo2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduleTest {

    /**
     * 向job传递参数方式一
     */
    public static void main(String[] args) throws SchedulerException {

        //1. 任务调度器，从工厂中获取调度的实例（默认：StdSchedulerFactory）
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2. 任务实例(JobDetail)
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)//加载任务类，与MyJob实现绑定，MyJob必须实现Job类
                .withIdentity("job1", "group1")//标识任务名(唯一实例)和组名
                .usingJobData("message", "job param") //向job传递参数
                .build();

        //3. 触发器（Trigger）
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()//立即执行
                .withIdentity("triger1", "group1")//标识触发器的名称(唯一实例)和组名
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(2))//第2秒执行一次
                .usingJobData("message", "_4trigger param")
                .build();

        //4. 让调度器关联任务和触发器
        scheduler.scheduleJob(jobDetail, trigger);

        //5. 启动
        scheduler.start();
    }

}
