package com.test.behavior.mode.mediator.mediator;

import com.test.behavior.mode.mediator.colleague.Component;

/**
 * 抽象中介者
 */
public abstract class Mediator {

    public abstract void componentChanged(Component component);
}
