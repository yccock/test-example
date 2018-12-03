package com.test.command.receiver;

/**
 * 接收者(Receiver)角色
 * 电视机操作类，具体的方法执行类
 */
public class Television {

    public void open(int i){
        System.out.println("打开电视机......现在频道是：" + i);
    }

    public void close(int i){
        System.out.println("关闭电视机......现在频道是：" + i);
    }

    public void changeChannel(int i){
        System.out.println("切换电视频道......现在频道是：" + i);
    }
}
