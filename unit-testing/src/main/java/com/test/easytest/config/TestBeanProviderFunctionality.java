package com.test.easytest.config;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Intercept;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.annotation.TestConfigProvider;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * EasyTest现在提供了一个将Inject字段放入测试类的工具。这是使用控制反转的概念实现的。您在测试用例之外的配置类中声明测试bean。
 * 这些配置bean可以由多个测试类使用。然后，在测试类上使用@TestConfigProvider注释指定测试Config类的类对象，告诉测试类从哪里
 * 获取配置bean。最后，使用@Provided注释声明EasyTest框架应该提供测试类中的哪些字段
 */
@RunWith(DataDrivenTestRunner.class)
@TestConfigProvider(ConfigProviderClass.class)
@DataLoader(filePaths= "params/csvData.csv", loaderType = LoaderType.CSV)
public class TestBeanProviderFunctionality {

    /**
     * @Intercept: 在某些情况下，用户想要测量他的服务实际用于返回测试数据的时间。这在您想要进行第一级性能分析并且需要大致了
     * 解哪些服务可能很慢的情况下非常有用。EasyTest为这种场景提供了方便的注释（@Intercept）支持
     *
     * @Inject: 作用注入
     */
    @Intercept
    @Inject
    public ItemService itemService;

    @Test
    public void simplTestMethod(@Param(name="name")String name, @Param(name="age")int age, @Param(name="expectedOutput")String expectedOutput){
        itemService.seep();
    }


}
