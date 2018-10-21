package com.test.singleton;


/**
 * 懒汉式
 */
public class SingletonDemo2 {

    private static SingletonDemo2 singletonDemo2 ;

    private SingletonDemo2() {}

    public synchronized static SingletonDemo2 getInstance(){
        if (singletonDemo2 == null) {
            singletonDemo2 = new SingletonDemo2();
        }
        return singletonDemo2;
    }
}
