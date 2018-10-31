package com.test.testng.multiThread;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/31 21:47
 * @description: TODO
 */
public class MultiThreadOnXml {


    @Test
    public void test1(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}
