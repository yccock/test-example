package com.test.worker.schedule;

import com.test.worker.context.ScheduleContext;
import com.test.worker.task.Task;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AbstractSchedule<T extends Task> implements Schedule {

    public final static Logger logger = LoggerFactory.getLogger(AbstractSchedule.class);

    protected final ScheduledExecutorService executorService;

    protected List<T> tasks;

//    protected String scheduleName;

    public AbstractSchedule(List<T> tasks) {
        this.executorService = Executors.newScheduledThreadPool(tasks.size());
        this.tasks = tasks;
//        this.scheduleName = String.format("%s-%s", this.tasks.get(0).getClass().getSimpleName(), this.tasks.get(0).getModelId());
//        logger.info("======scheduleName:{}", scheduleName);
    }

    public void startSchedule(int initialDelay, int delayInSecond, TimeUnit unit) {
        tasks.stream().forEach(task-> {
            executorService.scheduleWithFixedDelay(task, initialDelay, delayInSecond, unit);
        });
    }

    public void stopSchedule() {
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
        try {
            executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
            if (!executorService.isShutdown() || !executorService.isTerminated()) {
                executorService.shutdownNow();
            }
            if (executorService.shutdownNow().size() == 0) {
                ScheduleContext.getInstance().remove(this.tasks.get(0).getTaskUuid());
                logger.error("shutdown executorService success");
            }
        } catch (InterruptedException e) {
            logger.error(ExceptionUtils.getStackTrace(e));
        }
    }
}
