package com.test.structural.mode.decorator.demo1;

import com.test.structural.mode.decorator.demo1.component.Component;
import com.test.structural.mode.decorator.demo1.component.Window;
import com.test.structural.mode.decorator.demo1.decorator.ScorollBarDecorator;

public class Client {
    public static void main(String[] args) {
        Component window = new Window();
        ScorollBarDecorator scorollBarDecorator = new ScorollBarDecorator(window);
        scorollBarDecorator.display();
    }
}
