package com.test.factory.factorymethod.client;

import com.test.factory.factorymethod.Car;
import com.test.factory.factorymethod.factory.AudiFactory;
import com.test.factory.factorymethod.factory.BydFactory;

public class Client {

    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        Car byd = new BydFactory().createCar();

        audi.run();
        byd.run();
    }
}
