package com.test.adapter.client;

import com.test.adapter.Adapter;
import com.test.adapter.Target;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}
