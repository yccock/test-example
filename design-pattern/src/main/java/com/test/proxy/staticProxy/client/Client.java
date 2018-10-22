package com.test.proxy.staticProxy.client;

import com.test.proxy.staticProxy.Star;
import com.test.proxy.staticProxy.StarImpl;
import com.test.proxy.staticProxy.StarProxy;

public class Client {

    public static void main(String[] args) {
        Star star = new StarImpl();
        StarProxy proxy = new StarProxy(star);
        proxy.bookTicket();
        proxy.sing();
    }
}
