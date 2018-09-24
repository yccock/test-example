package com.test.classloader.unload;

public class UnLoadClass {

    public void show(){
        System.out.println(this.getClass().getClassLoader());
    }
}
