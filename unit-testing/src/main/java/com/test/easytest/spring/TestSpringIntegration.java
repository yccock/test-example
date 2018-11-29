package com.test.easytest.spring;

import com.test.easytest.converters.Item;
import com.test.easytest.converters.ItemConverter;
import com.test.module.dao.UserDAO;
import com.test.module.domain.User;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.SpringTestRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.beans.PropertyEditorManager;

@RunWith(SpringTestRunner.class)
@DataLoader(filePaths= "params/csvData.csv", loaderType = LoaderType.CSV)
@ContextConfiguration(classes = {XmlConfig.class}, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(transactionManager="txManager" )
@Transactional
public class TestSpringIntegration {

    @Autowired
    private UserDAO userDAO;

    @BeforeClass
    public static void before(){
        PropertyEditorManager.registerEditor(Item.class, ItemConverter.class);
    }

    @Test
    public void simplTestMethod(@Param(name="name")String name, @Param(name="age")int age, @Param(name="expectedOutput")String expectedOutput){
        User user = userDAO.findOneById(1L);
        System.out.println(user);
        System.out.println("=============name:" + name + "," + "age:" + age);
    }
}
