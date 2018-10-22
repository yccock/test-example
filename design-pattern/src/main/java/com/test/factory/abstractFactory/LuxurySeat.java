package com.test.factory.abstractFactory;

/**
 * 高端座椅
 */
public class LuxurySeat implements Seat {

    @Override
    public void message() {
        System.out.println("可以自动按摩");
    }
}
