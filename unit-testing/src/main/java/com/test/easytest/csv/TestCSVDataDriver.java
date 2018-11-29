package com.test.easytest.csv;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "params/csvData.csv", loaderType = LoaderType.CSV)
public class TestCSVDataDriver {

    /**
     * 参数化文件中第一列simplTestMethod是测试方法名，name,age即为测试数据标题，第二行就是测试数据了，第一列要为空
     */
    @Test
    public void simplTestMethod(@Param(name="name")String name, @Param(name="age")int age, @Param(name="expectedOutput")String expectedOutput){
        System.out.println("=============name:" + name + "," + "age:" + age);
    }

}
