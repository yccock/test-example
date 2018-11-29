package com.test.easytest.report;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.annotation.Report;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths= "params/excelData.xls", loaderType = LoaderType.EXCEL)
@Report(outputFormats = Report.EXPORT_FORMAT.XLS, outputLocation = "classpath:com/test/report")
public class TestExportReport {

    @Test
    public void simplTestMethod(@Param(name="name")String name, @Param(name="age")int age, @Param(name="expectedOutput")String expectedOutput){
        System.out.println("=============name:" + name + "," + "age:" + age);
    }
}
