package com.test.observer.custom.subject;


/**
 *  具体的目标类
 */
public class ConcreteSubject extends Subject{

    private int state;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;

        //主题对象（目标对象）的值发生变化时，请通知观察者
        this.notifyAllObservers();
    }
}
