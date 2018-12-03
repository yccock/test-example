package com.test.command.command;

import com.test.command.receiver.Television;

/**
 * 命令实现类, 具体命令(ConcreteCommand)角色
 */
public class OpenTvCommand implements Command {

    Television television;

    public OpenTvCommand() {
        this.television = new Television();
    }

    @Override
    public void execute(int i) {
        television.open(i);
    }
}
