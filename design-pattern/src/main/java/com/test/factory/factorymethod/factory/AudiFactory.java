package com.test.factory.factorymethod.factory;

import com.test.factory.factorymethod.Audi;
import com.test.factory.factorymethod.Car;

public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
