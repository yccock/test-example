package com.test.behavior.mode.command.demo1.invoker;

import com.test.behavior.mode.command.demo1.command.Command;

/**
 * 遥控器类，请求者(Invoker)角色
 */
public class ControllerInvoker {

    Command openTvCommand;
    Command closeTvCommand;
    Command changeChannelCommand;

    public int nowChannel = 0;       //当前频道
    public int priorChannel;     //前一个频道，用于执行返回操作

    public ControllerInvoker(Command openTvCommand, Command closeTvCommand, Command changeChannelCommand) {
        this.openTvCommand = openTvCommand;
        this.closeTvCommand = closeTvCommand;
        this.changeChannelCommand = changeChannelCommand;
    }

    /**
     * 打开电视
     */
    public void open() {
        openTvCommand.execute(0);
    }

    /**
     * 关闭电视
     */
    public void close() {
        closeTvCommand.execute(0);
    }

    /**
     * 换频道：只在当前频道递增
     */
    public void change(){
        priorChannel = nowChannel;//换频道前记录当前频道
        nowChannel++;   //频道+1
        changeChannelCommand.execute(nowChannel);
    }

    /**
     * 频道返回
     */
    public void channelUndo() {
        changeChannelCommand.execute(priorChannel);//将以前的频道传入
        //当前频道与前一个频道进行互换
        int tempChannel;
        tempChannel = priorChannel;
        priorChannel = nowChannel;
        nowChannel = tempChannel;
    }
}
