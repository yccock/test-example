package com.test.factory.abstractfactory;

/**
 * 高端座椅
 */
public class LuxurySeat implements Seat {

    @Override
    public void message() {
        System.out.println("可以自动按摩");
    }
}
