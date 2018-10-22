package com.test.proxy.staticProxy;

public class StarImpl implements Star {
    @Override
    public void bookTicket() {
        System.out.println("订票");
    }

    @Override
    public void sing() {
        System.out.println("唱歌");
    }
}
