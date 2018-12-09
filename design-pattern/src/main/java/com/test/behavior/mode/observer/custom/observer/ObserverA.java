package com.test.behavior.mode.observer.custom.observer;

import com.test.behavior.mode.observer.custom.subject.ConcreteSubject;
import com.test.behavior.mode.observer.custom.subject.Subject;

/**
 * 观察者A
 */
public class ObserverA implements Observer {

    private int myState; //myState需要跟目标对象的state一致

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }
    public void setMyState(int myState) {
        this.myState = myState;
    }
}
