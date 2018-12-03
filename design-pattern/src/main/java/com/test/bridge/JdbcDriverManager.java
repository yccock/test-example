package com.test.bridge;

/**
 * JDBC 驱动连接管理类
 */
public class JdbcDriverManager {

    public String connectAndReadOracle(){
        System.out.println("已成功连接到Oracle数据库");
        String content = "已成功从Oracle数据库中读取到了内容";
        return content;
    }

    public String connectAndReadMySql(){
        System.out.println("已成功连接到MySql数据库");
        String content = "已成功从MySql数据库中读取到了内容";
        return content;
    }

    public String connectAndReadSqlServer(){
        System.out.println("已成功连接到Sql Server数据库");
        String content = "已成功从Sql Server数据库中读取到了内容";
        return content;
    }
}
