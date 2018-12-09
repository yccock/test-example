package com.test.structural.mode.decorator.demo1.decorator;

import com.test.structural.mode.decorator.demo1.component.Component;

/**
 * /构件装饰类：抽象装饰类
 */
public class CompentDecorator extends Component {

    //维持对抽象构件类型对象的引用
    private Component component;

    public CompentDecorator(Component component) { //注入抽象构件
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
