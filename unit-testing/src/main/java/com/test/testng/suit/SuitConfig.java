package com.test.testng.suit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @author yccock
 * @date 2018/10/30 21:46
 * @description: TODO
 */
public class SuitConfig {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("beforeSuit");
    }

    @AfterSuite
    public void afterSuit(){
        System.out.println("afterSuit");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
