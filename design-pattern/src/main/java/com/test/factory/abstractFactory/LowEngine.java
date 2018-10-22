package com.test.factory.abstractFactory;

//低端发动机
public class LowEngine implements Engine {
    @Override
    public void start() {
        System.out.println("启动慢");
    }
}
