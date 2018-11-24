package com.test.testng.multiThread;

import org.testng.annotations.Test;


public class MultiThreadOnAnnotation {

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void test(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

}
