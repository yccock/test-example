package com.test.worker.api;

import com.test.worker.context.ScheduleContext;
import com.test.worker.schedule.AbstractSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MonitorSchedule extends AbstractSchedule<MonitorTask> {

    public final static Logger logger = LoggerFactory.getLogger(MonitorSchedule.class);

    public MonitorSchedule(List<MonitorTask> tasks) {
        super(tasks);
    }

    @Override
    public void startSchedule(int initialDelay, int delayInSecond, TimeUnit unit) {
        super.startSchedule(initialDelay, delayInSecond, unit);
        ScheduleContext.getInstance().putIfAbsent(super.tasks.get(0).getTaskUuid(), this);
    }

    @Override
    public void stopSchedule() {
        logger.info("======stop MonitorSchedule");
        for (MonitorTask task : super.tasks) {
            task.stopTask();
        }
        super.stopSchedule();
    }
}
