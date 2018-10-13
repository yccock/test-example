package com.test.worker.context;

import java.util.concurrent.ConcurrentHashMap;

public class ScheduleContext extends ConcurrentHashMap{

    public static ScheduleContext scheduleContext;

    private ScheduleContext() {}

    public static ScheduleContext getInstance(){
        if (scheduleContext == null) {
            synchronized (ScheduleContext.class) {
                if (scheduleContext == null) {
                    scheduleContext = new ScheduleContext();
                }
            }
        }
        return scheduleContext;
    }
}
