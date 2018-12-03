package com.test.bridge.service;

import com.test.bridge.JdbcDriverManager;

/**
 * 从Oracle数据库获取内容
 */
public class ReadContentFromOracle implements IReadContent {

    @Override
    public String readContent() {
        JdbcDriverManager jdbcDriver = new JdbcDriverManager();
        return jdbcDriver.connectAndReadOracle();
    }
}
