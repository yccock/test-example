package com.test.factory.factoryMethod.factory;

import com.test.factory.factoryMethod.Audi;
import com.test.factory.factoryMethod.Car;

public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
