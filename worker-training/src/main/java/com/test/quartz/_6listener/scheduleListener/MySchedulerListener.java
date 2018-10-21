package com.test.quartz._6listener.scheduleListener;

import org.quartz.*;

public class MySchedulerListener implements SchedulerListener {
    /**
     * 部署JobDetail时调用
     * @param trigger
     */
    @Override
    public void jobScheduled(Trigger trigger) {
        String name = trigger.getKey().getName();
        System.out.println(name + "完成部署");
    }

    /**
     * 卸载JobDetail时调用
     * @param triggerKey
     */
    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        System.out.println(triggerKey.getName() + "完成卸载");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String s) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String s) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {

    }

    @Override
    public void jobDeleted(JobKey jobKey) {

    }

    @Override
    public void jobPaused(JobKey jobKey) {

    }

    @Override
    public void jobsPaused(String s) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String s) {

    }

    @Override
    public void schedulerError(String s, SchedulerException e) {

    }

    @Override
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {

    }

    @Override
    public void schedulerStarting() {

    }

    @Override
    public void schedulerShutdown() {

    }

    @Override
    public void schedulerShuttingdown() {

    }

    @Override
    public void schedulingDataCleared() {

    }
}
