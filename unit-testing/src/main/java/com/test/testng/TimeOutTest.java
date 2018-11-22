package com.test.testng;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/31 22:12
 * @description: TODO
 */
public class TimeOutTest {

    @Test(timeOut = 3000)
    public void test() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void test2() throws InterruptedException {
        Thread.sleep(3000);
    }
}
