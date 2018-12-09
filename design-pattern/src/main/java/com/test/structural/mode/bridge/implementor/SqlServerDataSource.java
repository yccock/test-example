package com.test.structural.mode.bridge.implementor;

import com.test.structural.mode.bridge.JdbcDriverManager;

/**
 * 从sqlserver数据库获取内容
 */
public class SqlServerDataSource implements IDataSource {

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriver = new JdbcDriverManager();
        return jdbcDriver.connectAndReadSqlServer();
    }
}
