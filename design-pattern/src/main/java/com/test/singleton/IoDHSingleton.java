package com.test.singleton;

/**
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控 制烦琐，而且性能受影响。
 * 可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问 题，有没有一种方法，能够将两种单例的缺点都克服，
 * 而将两者的优点合二为一呢？答案 是：Yes！下面我们来学习这种更好的被称之为Initialization	Demand	Holder	(IoDH)的技术。

 */
public class IoDHSingleton {

    private IoDHSingleton(){}

    public static IoDHSingleton getInstance(){
        return HoldClass.instance;
    }

    private static class HoldClass {
        public static final IoDHSingleton instance = new IoDHSingleton();
    }

    public static void main(String[] args) {
        IoDHSingleton singleton1 = IoDHSingleton.getInstance();
        IoDHSingleton singleton2 = IoDHSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
    }
}
