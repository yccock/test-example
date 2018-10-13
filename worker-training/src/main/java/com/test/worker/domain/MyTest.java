package com.test.worker.domain;

public class MyTest extends BaseModel{

    private String name;

    public MyTest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyTest{" +
                "id=" + super.id +
                ", name='" + name + '\'' +
                '}';
    }
}
