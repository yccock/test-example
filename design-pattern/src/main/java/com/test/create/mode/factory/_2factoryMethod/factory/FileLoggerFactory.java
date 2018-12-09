package com.test.create.mode.factory._2factoryMethod.factory;

import com.test.create.mode.factory._2factoryMethod.FileLogger;
import com.test.create.mode.factory._2factoryMethod.Logger;

/**
 * 文件日志记录器工厂类：具体工厂
 */
public class FileLoggerFactory implements LoggerFactory{

    @Override
    public Logger createLogger() {
        //FileLogger初始化
        return new FileLogger();
    }
}
