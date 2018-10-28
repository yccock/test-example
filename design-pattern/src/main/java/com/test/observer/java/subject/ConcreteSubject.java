package com.test.observer.java.subject;

import java.util.Observable;


/**
 * 目标对象
 */
public class ConcreteSubject extends Observable {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        //表示目标对象巳做了更改
        setChanged();

        //通知所有的观察者
        notifyObservers(state);
    }
}
