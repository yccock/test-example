package com.test.testng.group.clazz;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/30 22:11
 * @description: TODO
 */
@Test(groups = "student")
public class GroupsOnClass2 {

    public void  stu1(){
        System.out.println("GroupsOnClass2中的stu1运行");
    }

    public void  stu2(){
        System.out.println("GroupsOnClass2中的stu2运行");
    }
}
