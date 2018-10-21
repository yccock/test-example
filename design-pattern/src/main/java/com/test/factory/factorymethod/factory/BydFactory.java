package com.test.factory.factorymethod.factory;

import com.test.factory.factorymethod.Byd;
import com.test.factory.factorymethod.Car;

public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}
