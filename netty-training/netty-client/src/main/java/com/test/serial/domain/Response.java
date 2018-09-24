package com.test.serial.domain;

/**
 * 响应实体类
 */
public class Response {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
