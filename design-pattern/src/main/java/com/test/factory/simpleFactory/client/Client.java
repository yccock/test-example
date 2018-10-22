package com.test.factory.simpleFactory.client;

import com.test.factory.simpleFactory.Car;
import com.test.factory.simpleFactory.factory.CarFactory;

public class Client {

    public static void main(String[] args) {
        Car audi = CarFactory.createAudi();
        Car byd = CarFactory.createByd();

        audi.run();
        byd.run();
    }
}
