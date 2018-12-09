package com.test.structural.mode.adapter.client;

import com.test.structural.mode.adapter.Adapter;
import com.test.structural.mode.adapter.Target;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}
