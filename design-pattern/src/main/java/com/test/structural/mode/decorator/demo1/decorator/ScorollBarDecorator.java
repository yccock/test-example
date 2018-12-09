package com.test.structural.mode.decorator.demo1.decorator;

import com.test.structural.mode.decorator.demo1.component.Component;

/**
 * 滚动条装饰类：具体装饰类
 */
public class ScorollBarDecorator extends CompentDecorator {

    public ScorollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setScorollBar();
        super.display();
    }

    public void setScorollBar(){
        System.out.println("为构件增加滚动条");
    }
}
