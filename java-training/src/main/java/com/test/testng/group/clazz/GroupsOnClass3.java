package com.test.testng.group.clazz;

import org.testng.annotations.Test;

/**
 * @author yccock
 * @date 2018/10/30 22:11
 * @description: TODO
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void teacher1(){
        System.out.println("GroupsOnClass3中的teacher1");
    }

    public void teacher2(){
        System.out.println("GroupsOnClass3中的teacher2");
    }
}
