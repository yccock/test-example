package com.test.create.mode.factory._2factoryMethod.factory;

import com.test.create.mode.factory._2factoryMethod.DatabaseLogger;
import com.test.create.mode.factory._2factoryMethod.Logger;

/**
 * 数据库日志记录器工厂类：具体工厂
 */
public class DatabaseLoggerFactory implements LoggerFactory{

    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
