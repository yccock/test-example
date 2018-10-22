package com.test.factory.abstractFactory.client;

import com.test.factory.abstractFactory.Engine;
import com.test.factory.abstractFactory.factory.CarFactory;
import com.test.factory.abstractFactory.factory.LuxuryCarFactory;

public class Client {

    public static void main(String[] args) {
        CarFactory carFactory = new LuxuryCarFactory();
        Engine engine = carFactory.createEngine();
        engine.start();

    }
}
