package com.test;

import com.test.okhttp.RequestTask;
import com.test.okhttp.ShutdownHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerStartup {

    private static final Logger logger = LoggerFactory.getLogger(ServerStartup.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.test");
        applicationContext.refresh();
        ShutdownHook shutdownHook = applicationContext.getBean(ShutdownHook.class);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));
        applicationContext.getBean(RequestTask.class).start();

        logger.info("server startup ...");
        Runtime.getRuntime().exit(0);
    }

}
