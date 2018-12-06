package com.test.factory._2factoryMethod.client;

import com.test.factory._2factoryMethod.Logger;
import com.test.factory._2factoryMethod.factory.DatabaseLoggerFactory;
import com.test.factory._2factoryMethod.factory.FileLoggerFactory;
import com.test.factory._2factoryMethod.factory.LoggerFactory;

public class Client {

    public static void main(String[] args) {
         LoggerFactory databaseLoggerFactory = new DatabaseLoggerFactory();	//可引入配置文件实现
        Logger databaseLogger =  databaseLoggerFactory.createLogger();
        databaseLogger.writeLog();

        FileLoggerFactory fileLoggerFactory = new FileLoggerFactory(); //可引入配置文件实现
        Logger fileLogger = fileLoggerFactory.createLogger();
        fileLogger.writeLog();
    }
}
