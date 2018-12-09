package com.test.create.mode.singleton;

/**
 * 饿汉式
 */
public class EageSingleton {

    private static EageSingleton eageSingleton = new EageSingleton();

    private EageSingleton() {}

    public static EageSingleton getInstance(){
        return eageSingleton;
    }
}
