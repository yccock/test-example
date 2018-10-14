package com.test.quartz._3SteafulJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 无状态Job：普通的任务，或者说无状态的任务，在JobDetail执行之后，不会记录状态
 * 有状态StatefulJob：继承自Job，由于在定义时添加了@PersistJobDataAfterExecution注释，所以是有状态的任务，
 * 在Schedule执行完triger之后，会将实现了该接口的任务状态记录到数据库中
 */
@PersistJobDataAfterExecution
public class SteafulJob implements Job {

    // job实现类中添加setter方法对应JobDataMap的键值名后，Quartz框架默认的JobFactory实现类初始化Job实例对象时会自动
    // 调用这些setter方法，给属性赋值
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("===================================");
        System.out.println("job传递的message参数：" + message);
        ++count;
        System.out.println("job传递的count参数：" + count);
        //添加@PersistJobDataAfterExecution后，多次调用job期间可以持有一些状态，即可以实现count的累加
        //将count放到JobDataMap中
        jobExecutionContext.getJobDetail().getJobDataMap().put("count", count);
        System.out.println("===================================");
    }
}
