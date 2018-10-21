package com.test.factory.simplefactory.client;

import com.test.factory.simplefactory.Car;
import com.test.factory.simplefactory.factory.CarFactory;

public class Client {

    public static void main(String[] args) {
        Car audi = CarFactory.createAudi();
        Car byd = CarFactory.createByd();

        audi.run();
        byd.run();
    }
}
