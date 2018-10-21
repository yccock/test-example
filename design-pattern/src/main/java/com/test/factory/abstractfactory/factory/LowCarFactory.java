package com.test.factory.abstractfactory.factory;

import com.test.factory.abstractfactory.Engine;
import com.test.factory.abstractfactory.LowEngine;
import com.test.factory.abstractfactory.LowSeat;
import com.test.factory.abstractfactory.Seat;

public class LowCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }
}
