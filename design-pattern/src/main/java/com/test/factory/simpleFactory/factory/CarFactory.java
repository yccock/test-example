package com.test.factory.simpleFactory.factory;

import com.test.factory.simpleFactory.Audi;
import com.test.factory.simpleFactory.Byd;
import com.test.factory.simpleFactory.Car;

public class CarFactory {

    public static Car createAudi(){
        return new Audi();
    }

    public static Car createByd(){
        return new Byd();
    }
}
