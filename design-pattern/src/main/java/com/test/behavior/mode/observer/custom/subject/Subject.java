package com.test.behavior.mode.observer.custom.subject;

import com.test.behavior.mode.observer.custom.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标类
 */
public class Subject {

    protected List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者
     * @param observer
     */
    public void redisterObserver(Observer observer){
        this.observers.add(observer);
    }

    /**
     *   移除观察者
     * @param observer
     */
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
