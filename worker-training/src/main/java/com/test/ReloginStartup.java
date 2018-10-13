package com.test;

import com.test.relogin.RequestTask;
import com.test.relogin.ShutdownHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReloginStartup {

    private static final Logger logger = LoggerFactory.getLogger(ReloginStartup.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.test.relogin");
        applicationContext.refresh();
        ShutdownHook shutdownHook = applicationContext.getBean(ShutdownHook.class);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));
        applicationContext.getBean(RequestTask.class).start();

        logger.info("server startup ...");
        Runtime.getRuntime().exit(0);
    }

}
