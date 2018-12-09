package com.test.behavior.mode.command.demo2.command;

import com.test.behavior.mode.command.demo2.receiver.HelpHandler;

/**
 * 帮助命令类：具体命令类
 */
public class HelpCommand extends Command {

    private HelpHandler helpHandler; //维持对请求接收者的引用

    public HelpCommand() {
        helpHandler = new HelpHandler();
    }

    /**
     * 命令执行方法，将调用请求接收者的业务方法
     */
    @Override
    public void execute() {
        helpHandler.display();
    }
}
