package com.test.behavior.mode.command.demo2;

import com.test.behavior.mode.command.demo2.command.Command;
import com.test.behavior.mode.command.demo2.command.HelpCommand;
import com.test.behavior.mode.command.demo2.command.MinimizeCommand;
import com.test.behavior.mode.command.demo2.invoker.FuntionButton;

/**
 * 为了降低功能键与功能处理类之间的耦合度，让用户可以自定义每一个功能键的功能，Sunny
 * 软件公司开发人员使用命令模式来设计“自定义功能键”模块
 * FBSettingWindow是“功能键设置”界面类，FunctionButton充当请求调用者，
 * Command充当抽象命令类，MinimizeCommand和HelpCommand充当具体命令类，
 * WindowHanlder和HelpHandler充当请求接收者
 */
public class Client {

    public static void main(String[] args) {
        FuntionWindowSetting funtionWindowSetting = new FuntionWindowSetting("功能键设置");
        FuntionButton button1 = new FuntionButton("功能键1");
        FuntionButton button2 = new FuntionButton("功能键2");

        Command command1 = new HelpCommand();
        Command command2 = new MinimizeCommand();

        //将命令对象注入功能键
        button1.setCommand(command2);
        button2.setCommand(command1);

        funtionWindowSetting.addFuntionButton(button1);
        funtionWindowSetting.addFuntionButton(button2);
        funtionWindowSetting.display();

        //调用功能键的业务方法
        button1.onClick();
        button2.onClick();

    }
}
