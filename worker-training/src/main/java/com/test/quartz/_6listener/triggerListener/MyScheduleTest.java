package com.test.quartz._6listener.triggerListener;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;

public class MyScheduleTest {

    /**
     * 入门实例
     * @param args
     * @throws SchedulerException
     */
    public static void main(String[] args) throws SchedulerException {

        //1. 任务调度器，从工厂中获取调度的实例（默认：StdSchedulerFactory）
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //2. 任务实例(JobDetail)
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)//加载任务类，与MyJob实现绑定，MyJob必须实现Job类
                .withIdentity("job1", "group1")//标识任务名(唯一实例)和组名
                .build();

        //3. 触发器（Trigger）
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()//立即执行
                .withIdentity("triger1", "group1")//标识触发器的名称(唯一实例)和组名
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(2))//第2秒执行一次
                .build();

        //4. 让调度器关联任务和触发器
        scheduler.scheduleJob(jobDetail, trigger);

        //创建并注册一个全局的Trigger Listener
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),
                EverythingMatcher.allTriggers());

        //创建并注册一个局部的Trigger Listener，表示指定的job任务
        scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(),
                KeyMatcher.keyEquals(TriggerKey.triggerKey("triger1", "group1")));

        //5. 启动
        scheduler.start();
    }

}
