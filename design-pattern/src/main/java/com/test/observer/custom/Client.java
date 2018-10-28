package com.test.observer.custom;

import com.test.observer.custom.observer.ObserverA;
import com.test.observer.custom.subject.ConcreteSubject;

public class Client {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ObserverA obj1 = new ObserverA();
        ObserverA obj2 = new ObserverA();
        ObserverA obj3 = new ObserverA();

        subject.redisterObserver(obj1);
        subject.redisterObserver(obj2);
        subject.redisterObserver(obj3);

        //改变subect的state
        subject.setState(1);

        System.out.println("==========");
        System.out.println(obj1.getMyState());
        System.out.println(obj2.getMyState());
        System.out.println(obj3.getMyState());
    }
}
