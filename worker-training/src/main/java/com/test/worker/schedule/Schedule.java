package com.test.worker.schedule;

import java.util.concurrent.TimeUnit;

public interface Schedule {

    void startSchedule(int initialDelay, int delayInSecond, TimeUnit unit);

    void stopSchedule();
}
