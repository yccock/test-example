package com.test.factory.factoryMethod.client;

import com.test.factory.factoryMethod.Car;
import com.test.factory.factoryMethod.factory.AudiFactory;
import com.test.factory.factoryMethod.factory.BydFactory;

public class Client {

    public static void main(String[] args) {
        Car audi = new AudiFactory().createCar();
        Car byd = new BydFactory().createCar();

        audi.run();
        byd.run();
    }
}
