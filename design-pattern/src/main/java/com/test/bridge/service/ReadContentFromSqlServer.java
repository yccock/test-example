package com.test.bridge.service;

import com.test.bridge.JdbcDriverManager;

/**
 * 从sqlserver数据库获取内容
 */
public class ReadContentFromSqlServer implements IReadContent {

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriver = new JdbcDriverManager();
        return jdbcDriver.connectAndReadSqlServer();
    }
}
