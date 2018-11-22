package com.test.testng.parameter2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @author yccock
 * @date 2018/10/30 22:41
 * @description: DataProvider参数化
 */
public class DataProviderTest2 {

    @Test(dataProvider = "mehtodData")
    public void test1(String name, int age){
        System.out.println("test1方法，name=" + name + ", age = " + age);
    }

    @Test(dataProvider = "mehtodData")
    public void test2(String name, int age){
        System.out.println("test2方法，name=" + name + ", age = " + age);
    }

    @DataProvider(name = "mehtodData")
    public Object[][] mehtodDataTest(Method method){
        Object[][] objects = null;
        if (method.getName().equals("test1")) {
            objects = new Object[][]{
                    {"zhangshan", 15},
                    {"lishi", 18},
            };
        }else if (method.getName().equals("test2")) {
            objects = new Object[][]{
                    {"wangwu", 50},
                    {"zhaoliu", 60},
            };
        }
        return objects;
    }
}
