package com.test.serial.domain;

/**
 * 发送实体类
 */
public class Request {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private byte[] attach;

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

    public byte[] getAttach() {
        return attach;
    }

    public void setAttach(byte[] attach) {
        this.attach = attach;
    }
}
