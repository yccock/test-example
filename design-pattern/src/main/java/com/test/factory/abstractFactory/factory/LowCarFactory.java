package com.test.factory.abstractFactory.factory;

import com.test.factory.abstractFactory.Engine;
import com.test.factory.abstractFactory.LowEngine;
import com.test.factory.abstractFactory.LowSeat;
import com.test.factory.abstractFactory.Seat;

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
