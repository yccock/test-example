package com.test.testng.parameter1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @description: 通过xml进行参数化测试
 */
public class ParameterTest {

    @Test
    @Parameters({"name", "age"})
    public void paraTest1(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
    }
}
