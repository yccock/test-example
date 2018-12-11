package com.test.behavior.mode.mediator.colleague;

import com.test.behavior.mode.mediator.mediator.Mediator;

/**
 * 抽象组件类：抽象同事类
 */
public abstract class Component {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed() {
        this.mediator.componentChanged(this);
    }

    public abstract void update();

}
