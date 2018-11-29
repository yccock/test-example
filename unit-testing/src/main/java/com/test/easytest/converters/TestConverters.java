package com.test.easytest.converters;

import org.easetech.easytest.annotation.Converters;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 注册转换器
 */
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "params/csvData.csv", loaderType = LoaderType.CSV)
@Converters({ItemConverter.class})
public class TestConverters {

    /**
     * 注册转换器后，可以使用自定义对象User传递给方法
     */
    @Test
    public void simplTestMethod(Item item){
        System.out.println("=============name:" + item.getName() + "," + "age:" + item.getAge());
    }
}
