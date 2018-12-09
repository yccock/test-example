package com.test.structural.mode.proxy.staticProxy.extend;

public class Logger {

    //模拟实现日志记录
    public void writeLog(String userId) {
        System.out.println(String.format("更新数据库，用户%s查询次数加1", userId));
    }
}
