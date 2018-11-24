package com.test.testng.parameter2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @description: DataProvider参数化
 */
public class DataProviderTest {

    @Test(dataProvider = "datas")
    public void testDataProvider(String name, int age) {
        System.out.println("name = " + name + ", age = " + age);
    }

    @DataProvider(name = "datas")
    public Object[][] providerData(){
        Object[][] objects = new Object[][]{
                {"zhangshan", 15},
                {"lishi", 18},
        };
        return objects;
    }
}
