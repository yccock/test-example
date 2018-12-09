package com.test.create.mode.singleton;


/**
 * 懒汉式
 */
public class LazySingleton {

    private static LazySingleton lazySingleton;

    private LazySingleton() {}

    public static LazySingleton getInstance(){
        //第一重判断
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                //第二重判断
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }

        }
        return lazySingleton;
    }
}
