package com.test.easytest.xml;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "params/xmlData.xml", loaderType = LoaderType.XML)
public class TestXmlDataDriver {

    @Test
    public void simplTestMethod(@Param(name="name")String name, @Param(name="age")int age, @Param(name="expectedOutput")String expectedOutput){
        System.out.println("=============name:" + name + "," + "age:" + age);
    }
}
