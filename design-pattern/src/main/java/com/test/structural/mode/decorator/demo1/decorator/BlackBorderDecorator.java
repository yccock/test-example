package com.test.structural.mode.decorator.demo1.decorator;

import com.test.structural.mode.decorator.demo1.component.Component;

/**
 * 黑色边框装饰类：具体装饰类
 */
public class BlackBorderDecorator extends CompentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("为构件增加黑色边框");
    }
}
