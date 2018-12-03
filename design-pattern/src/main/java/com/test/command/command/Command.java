package com.test.command.command;

/**
 * Command命令接口，为所有的命令声明一个接口。所有的命令都应该实现它
 */
public interface Command {

     /**
      * 为了方便切换频道，这里使用参数i将频道传递
      * @param i
      */
     public void execute(int i);
}
