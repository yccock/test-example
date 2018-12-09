package com.test.behavior.mode.observer.java.observer;

import com.test.behavior.mode.observer.java.subject.ConcreteSubject;

import java.util.Observable;
import java.util.Observer;

/**
 *  观察者类
 */
public class ObserverB implements Observer{

    private int mystate;

    @Override
    public void update(Observable o, Object arg) {
        mystate = ((ConcreteSubject) o).getState();
    }

    public int getMystate() {
        return mystate;
    }
    public void setMystate(int mystate) {
        this.mystate = mystate;
    }
}
