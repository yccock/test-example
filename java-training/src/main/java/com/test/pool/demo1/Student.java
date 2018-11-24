package com.test.pool.demo1;

/**
 * @Description: 假设这是一个建立TCP连接的对象，该对象的初始化时间平均为500ms，为了避免在程序中频繁创建Conn对象，
 * 我们需要借助对象池管理Conn对象实例
 */
public class Student {

    private String name;

    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // @Override
    // public String toString() {
    //     return "Student{" +
    //             "name='" + name + '\'' +
    //             ", age=" + age +
    //             '}';
    // }
}
