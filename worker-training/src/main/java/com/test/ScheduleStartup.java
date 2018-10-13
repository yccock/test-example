package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScheduleStartup {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        synchronized (ScheduleStartup.class) {
            while (true) {
                ScheduleStartup.class.wait();
            }
        }
    }
}
