package com.test.behavior.mode.command.demo2.command;

import com.test.behavior.mode.command.demo2.receiver.WindowHandler;

/**
 * 最小化命令类：具体命令类
 */
public class MinimizeCommand extends Command {

    private WindowHandler windowHandler;

    public MinimizeCommand() {
        windowHandler = new WindowHandler();
    }

    /**
     * 命令执行方法，将调用请求接收者的业务方法
     */
    @Override
    public void execute() {
        windowHandler.minimize();
    }
}
