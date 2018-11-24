package com.test.testng.depend.dependsOnMethods;

import org.testng.annotations.Test;

/**
 * 有时候，我们需要按顺序来调用测试用例，  那么测试用例之间就存在依赖关系。 TestNG支持测试用例之间的依赖
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
