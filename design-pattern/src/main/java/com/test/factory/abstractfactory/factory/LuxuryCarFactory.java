package com.test.factory.abstractfactory.factory;

import com.test.factory.abstractfactory.Engine;
import com.test.factory.abstractfactory.LuxuryEngine;
import com.test.factory.abstractfactory.LuxurySeat;
import com.test.factory.abstractfactory.Seat;

public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }
}
