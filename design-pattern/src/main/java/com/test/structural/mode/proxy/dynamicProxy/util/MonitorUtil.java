package com.test.structural.mode.proxy.dynamicProxy.util;

public class MonitorUtil {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void start() {
        threadLocal.set(System.currentTimeMillis());
    }

    public static void finish() {
        System.out.println("方法耗时：" + (System.currentTimeMillis() - threadLocal.get()) + "ms");
    }
}
