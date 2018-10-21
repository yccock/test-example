package com.test.factory.abstractfactory.client;

import com.test.factory.abstractfactory.Engine;
import com.test.factory.abstractfactory.factory.CarFactory;
import com.test.factory.abstractfactory.factory.LuxuryCarFactory;

public class Client {

    public static void main(String[] args) {
        CarFactory carFactory = new LuxuryCarFactory();
        Engine engine = carFactory.createEngine();
        engine.start();

    }
}
