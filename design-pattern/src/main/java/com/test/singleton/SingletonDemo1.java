package com.test.singleton;

/**
 * 饿汉式
 */
public class SingletonDemo1 {

    private static SingletonDemo1 singletonDemo1 = new SingletonDemo1();

    private SingletonDemo1() {}

    public static SingletonDemo1 getInstance(){
        return singletonDemo1;
    }
}
