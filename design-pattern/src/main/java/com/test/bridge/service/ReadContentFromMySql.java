package com.test.bridge.service;

import com.test.bridge.JdbcDriverManager;

/**
 * 从mysql数据库获取内容
 */
public class ReadContentFromMySql implements IReadContent {

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriver = new JdbcDriverManager();
        return jdbcDriver.connectAndReadMySql();
    }
}
