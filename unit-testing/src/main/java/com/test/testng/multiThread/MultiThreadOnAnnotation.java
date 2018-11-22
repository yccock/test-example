package com.test.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/31 21:46
 * @description: TODO
 */
public class MultiThreadOnAnnotation {

    @Test(invocationCount = 3, threadPoolSize = 3)
    public void test(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

}
