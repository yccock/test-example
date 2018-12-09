package com.test.behavior.mode.command.demo1;

import com.test.behavior.mode.command.demo1.command.Command;
import com.test.behavior.mode.command.demo1.command.ChangeChannelCommand;
import com.test.behavior.mode.command.demo1.command.CloseTvCommand;
import com.test.behavior.mode.command.demo1.command.OpenTvCommand;
import com.test.behavior.mode.command.demo1.invoker.ControllerInvoker;

public class Client {

    public static void main(String[] args) {
        Command openCommand = new OpenTvCommand();
        Command closeCommand = new CloseTvCommand();
        Command changeCommand = new ChangeChannelCommand();

        //遥控器
        ControllerInvoker controllerInvoker = new ControllerInvoker(openCommand, closeCommand, changeCommand);

        controllerInvoker.open();           //打开电视机
        controllerInvoker.change();         //换频道
        controllerInvoker.change();
        controllerInvoker.channelUndo();    //频道返回
        controllerInvoker.channelUndo();
        controllerInvoker.channelUndo();
        controllerInvoker.close();          //关闭电视机
    }
}
