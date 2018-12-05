package com.test.chain;


import com.test.chain.concrete.handler.Director;
import com.test.chain.concrete.handler.GeneralManager;
import com.test.chain.concrete.handler.Manager;
import com.test.chain.handler.Leader;

public class Client {

    public static void main(String[] args) {
        Leader director = new Director("张三");
        Leader manager = new Manager("李四");
        Leader generalManager = new GeneralManager("王五");

        // 组织好责任链对象的关系
        director.setNextLeader(manager);
        manager.setNextLeader(generalManager);

        LeaveRequest leaveRequest = new LeaveRequest("赵六", 15, "出去旅游");
        director.handleRequest(leaveRequest);
    }
}
