package com.test.proxy.staticProxy;

public class StarProxy implements Star {
    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }

    @Override
    public void bookTicket() {
        star.bookTicket();
    }

    @Override
    public void sing() {
        star.sing();
    }
}
