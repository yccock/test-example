package com.test.behavior.mode.mediator;

import com.test.behavior.mode.mediator.colleague.Button;
import com.test.behavior.mode.mediator.colleague.ComboBox;
import com.test.behavior.mode.mediator.colleague.List;
import com.test.behavior.mode.mediator.colleague.TextBox;
import com.test.behavior.mode.mediator.mediator.ConcreteMediator;

/**
 * Component充当抽象同事类，Button、List、ComboBox和TextBox充当具体同事 类，Mediator充当抽象中介者类，
 * ConcreteMediator充当具体中介者类，ConcreteMediator维持 了对具体同事类的引用
 */
public class Client {

    public static void main(String[] args) {
        //定义中介者对象
        ConcreteMediator mediator = new ConcreteMediator();

        //定义同事
        Button addButton = new Button();
        List list = new List();
        ComboBox comboBox = new ComboBox();
        TextBox userNameTextBox = new TextBox();

        addButton.setMediator(mediator);
        list.setMediator(mediator);
        comboBox.setMediator(mediator);
        userNameTextBox.setMediator(mediator);

        //中介者注册同事对象
        mediator.register(addButton);
        mediator.register(list);
        mediator.register(comboBox);
        mediator.register(userNameTextBox);

        addButton.changed();
        System.out.println("-----------------------------");
        list.changed();
    }
}
