package com.test.testng.group.clazz;

import org.testng.annotations.Test;


@Test(groups = "student")
public class GroupsOnClass1 {

    public void  stu1(){
        System.out.println("GroupsOnClass1中的stu1运行");
    }

    public void  stu2(){
        System.out.println("GroupsOnClass1中的stu2运行");
    }
}
