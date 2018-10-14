package com.test.quartz._2JobDataMap.demo3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;

public class MyJob implements Job {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 如果你添加了 set 方法到你的 Job 类中，并且和 _2JobDataMap 中存放的键一致
    // Quartz框架默认的JobFactory实现类初始化Job实例对象时会自动
    // 调用这些setter方法，给属性赋值
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===================================");
        System.out.println("job传递的参数：" + message);
        System.out.println("===================================");
    }
}
