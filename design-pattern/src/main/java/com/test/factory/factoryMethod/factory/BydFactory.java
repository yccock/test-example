package com.test.factory.factoryMethod.factory;

import com.test.factory.factoryMethod.Byd;
import com.test.factory.factoryMethod.Car;

public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
