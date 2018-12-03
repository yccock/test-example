package com.test.command;

import com.test.command.command.Command;
import com.test.command.command.ChangeChannelCommand;
import com.test.command.command.CloseTvCommand;
import com.test.command.command.OpenTvCommand;
import com.test.command.invoker.ControllerInvoker;

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
