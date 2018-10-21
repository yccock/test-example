package com.test.factory.abstractfactory;

//高端发动机
public class LuxuryEngine implements Engine{
    @Override
    public void start() {
        System.out.println("启动快");
    }
}
