package com.test.behavior.mode.observer.java;


import com.test.behavior.mode.observer.java.observer.ObserverB;
import com.test.behavior.mode.observer.java.subject.ConcreteSubject;

public class Client {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ObserverB obj1 = new ObserverB();
        ObserverB obj2 = new ObserverB();
        ObserverB obj3 = new ObserverB();

        //将三个观察者对象加到目标对象subject的观察者窗器中
        subject.addObserver(obj1);
        subject.addObserver(obj2);
        subject.addObserver(obj3);

        //改变subect的state
        subject.setState(1);

        System.out.println("==========");
        System.out.println(obj1.getMystate());
        System.out.println(obj2.getMystate());
        System.out.println(obj3.getMystate());
    }
}
