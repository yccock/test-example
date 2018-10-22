package com.test.factory.abstractFactory;

/**
 * 低端座椅
 */
public class LowSeat implements Seat {

    @Override
    public void message() {
        System.out.println("不能按摩");
    }
}
