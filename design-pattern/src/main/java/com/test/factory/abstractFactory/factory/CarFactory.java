package com.test.factory.abstractFactory.factory;

import com.test.factory.abstractFactory.Engine;
import com.test.factory.abstractFactory.Seat;

public interface CarFactory {

    Engine createEngine();

    Seat createSeat();
}
