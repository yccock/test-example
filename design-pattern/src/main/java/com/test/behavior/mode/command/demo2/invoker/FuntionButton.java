package com.test.behavior.mode.command.demo2.invoker;

import com.test.behavior.mode.command.demo2.command.Command;

/**
 * 功能键类：请求发送者
 */
public class FuntionButton {

    private String name; //功能键名称
    private Command command; //维持一个抽象命令对象的引用

    public FuntionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 发送请求的方法
     */
    public void onClick() {
        System.out.println("点击功能键" + name);

        command.execute();
    }
}
