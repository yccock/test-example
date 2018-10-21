package com.test.factory.simplefactory.factory;

import com.test.factory.simplefactory.Audi;
import com.test.factory.simplefactory.Byd;
import com.test.factory.simplefactory.Car;

public class CarFactory {

    public static Car createAudi(){
        return new Audi();
    }

    public static Car createByd(){
        return new Byd();
    }
}
