package com.test.quartz._6listener.triggerListener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MyTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        String triggerName = this.getClass().getName();
        System.out.println("===触发器名称是:" + triggerName);
        return triggerName;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        String name = trigger.getKey().getName();
        System.out.println(name + "被触发");
    }

    /**
     * 在Trigger被触发后，Job将要被执行时由Scheduler调用这个方法
     * @param trigger
     * @param jobExecutionContext
     * @return
     */
    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        //TriggerListener给了一个选择去否决job的执行,假如返回true,这个job将不会为此次Trigger触发而得到执行
        return false;//true表示不会执行job的方法
    }

    /**
     * Scheduler调用这个方法是在Trigger错过触发时
     * @param trigger
     */
    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    /**
     * trigger被触发并且完成了job的执行时调用
     * @param trigger
     * @param jobExecutionContext
     * @param completedExecutionInstruction
     */
    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {

    }
}
