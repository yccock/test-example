package com.test.testng.group.clazz;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/30 22:09
 * @description: 类分组
 */
@Test(groups = "student")
public class GroupsOnClass1 {

    public void  stu1(){
        System.out.println("GroupsOnClass1中的stu1运行");
    }

    public void  stu2(){
        System.out.println("GroupsOnClass1中的stu2运行");
    }
}
