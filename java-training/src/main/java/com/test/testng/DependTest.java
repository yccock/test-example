package com.test.testng;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/30 22:29
 * @description: 依赖测试
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    //依赖于test1方法
    //当依赖的test1方法抛出异常时，test2方法会不执行
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
