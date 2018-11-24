package com.test.testng;

import org.testng.annotations.Test;

/**
 * @description: 忽略测试
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1");
    }

    /**
     * 忽略测试
     */
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3");
    }
}
