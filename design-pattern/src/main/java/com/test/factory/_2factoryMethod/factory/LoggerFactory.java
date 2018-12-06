package com.test.factory._2factoryMethod.factory;

import com.test.factory._2factoryMethod.Logger;

/**
 * 日志记录器工厂接口：抽象工厂
 */
public interface LoggerFactory {

    public Logger createLogger();
}
