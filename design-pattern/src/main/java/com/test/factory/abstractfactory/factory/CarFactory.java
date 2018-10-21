package com.test.factory.abstractfactory.factory;

import com.test.factory.abstractfactory.Engine;
import com.test.factory.abstractfactory.Seat;

public interface CarFactory {

    Engine createEngine();

    Seat createSeat();
}
