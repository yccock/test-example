package com.test.javassist.demo2;

public class Hello {

    public void print(){
        System.out.println("============hello print");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
