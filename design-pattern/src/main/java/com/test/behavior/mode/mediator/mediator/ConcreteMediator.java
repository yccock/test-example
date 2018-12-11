package com.test.behavior.mode.mediator.mediator;

import com.test.behavior.mode.mediator.colleague.*;

/**
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {

    //维持对各个同事对象的引用
    public Button button;
    public List list;
    public ComboBox comboBox;
    public TextBox userNameTextBox;

    //中介者注册
    public void register(Component component) {
        if (component instanceof Button) {
            button = (Button) component;
        } else if (component instanceof List) {
            list = (List) component;
        } else if (component instanceof ComboBox) {
            comboBox = (ComboBox) component;
        } else if (component instanceof TextBox) {
            userNameTextBox = (TextBox) component;
        }
    }

    //封装同事对象之间的交互
    @Override
    public void componentChanged(Component component) {
        //单击按钮
        if (component instanceof Button) {
            System.out.println("--单击增加按钮--");
            list.update();
            comboBox.update();
            userNameTextBox.update();
        } else if (component instanceof List) { //从列表框选择客
            System.out.println("--从列表框选择客户--");
            comboBox.select();
            userNameTextBox.setText();
        } else if (component instanceof TextBox) {
            System.out.println("--从组合框选择客户--");
            comboBox.select();
            userNameTextBox.setText();
        }
    }
}
