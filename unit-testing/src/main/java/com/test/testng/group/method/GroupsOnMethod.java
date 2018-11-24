package com.test.testng.group.method;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("server group:test1");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("server group:test2");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("client group:test3");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("client group:test4");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("before server group run");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("after server group run");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("before client group run");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("before client group run");
    }
}
