package com.test.observer.custom.observer;

import com.test.observer.custom.subject.Subject;

/**
 * 观察者类
 */
public interface Observer {

    public void update(Subject subject);
}
