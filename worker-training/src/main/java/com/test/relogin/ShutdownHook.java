package com.test.relogin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShutdownHook implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(ShutdownHook.class);

    @Autowired
    private RequestTask requestTask;

    public void run() {
        logger.info("shutdown application");
        requestTask.shutdown();
    }
}
