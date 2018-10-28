package com.test.classloader.hotswap;

/**
 * 用于修改，测试热加载
 */
public class Hot {

    public void show(){
        System.out.println(this.getClass().getClassLoader());
    }
}
