package com.test.quartz._6listener.jobListener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListemer implements JobListener {
    @Override
    public String getName() {
        String listenerName = this.getClass().getName();
        System.out.println("===监听器名称是:" + listenerName);
        return listenerName;
    }

    /**
     * Scheduler在JobDetail将在被执行时调用的方法
     * @param jobExecutionContext
     */
    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("===job名称：" + jobName);
        System.out.println("===Scheduler在JobDetail将在被执行时调用的方法");
    }

    /**
     * Scheduler在JobDetail即将被执行，但又被TriggerListener否决时调用该方法
     * @param jobExecutionContext
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {

    }

    /**
     * Scheduler在JobDetail被执行之后调用该方法
     * @param jobExecutionContext
     * @param e
     */
    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {

    }
}
