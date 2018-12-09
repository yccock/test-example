package com.test.behavior.mode.observer.custom.observer;

import com.test.behavior.mode.observer.custom.subject.Subject;

/**
 * 观察者类
 */
public interface Observer {

    public void update(Subject subject);
}
