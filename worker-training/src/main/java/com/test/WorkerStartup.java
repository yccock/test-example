package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WorkerStartup {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
        synchronized (WorkerStartup.class) {
            while (true) {
                WorkerStartup.class.wait();
            }
        }
    }
}
