package com.test.worker.api.impl;

import com.test.api.MonitorService;
import com.test.worker.api.MonitorSchedule;
import com.test.worker.api.MonitorTask;
import com.test.worker.context.ScheduleContext;
import com.test.worker.domain.MyTest;
import com.test.worker.schedule.Schedule;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 对外提供服务接口类
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @PostConstruct
    public void start(){
        long start = System.currentTimeMillis();
        startMonitor();
        long end = start + 30000;
        while (end - System.currentTimeMillis() > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stopMonitor();
    }

    public void startMonitor() {
        List<MyTest> myTests = getMyTests();
        List<MonitorTask> monitorTasks = myTests.stream()
                .map(myTest -> new MonitorTask(myTest))
                .collect(Collectors.toList());
        Schedule schedule = new MonitorSchedule(monitorTasks);
        schedule.startSchedule(1, 10, TimeUnit.SECONDS);
    }

    public void stopMonitor() {
        List<MyTest> myTests = getMyTests();
        String taskUuid = String.format("%s-%s", myTests.get(0).getClass().getSimpleName(), myTests.get(0).getId());
        MonitorSchedule monitorSchedule = (MonitorSchedule) ScheduleContext.getInstance().get(taskUuid);
        monitorSchedule.stopSchedule();
    }

    private List<MyTest> getMyTests(){
        MyTest myTest1 = new MyTest(1L, "test1");
        MyTest myTest2 = new MyTest(2L, "test2");
        List<MyTest> myTests = new ArrayList<MyTest>();
        myTests.add(myTest1);
        myTests.add(myTest2);
        return myTests;
    }
}
