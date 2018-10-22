package com.test.factory.abstractFactory.factory;

import com.test.factory.abstractFactory.Engine;
import com.test.factory.abstractFactory.LuxuryEngine;
import com.test.factory.abstractFactory.LuxurySeat;
import com.test.factory.abstractFactory.Seat;

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
