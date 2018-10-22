package com.test.prototype.shallowClone;

import java.util.Date;


/**
 * 浅复制测试
 */
public class ShallowCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(2313111231L);
        Sheep sheep1 = new Sheep("浅复制测试", date);
        System.out.println(sheep1);

        Sheep sheep2 = (Sheep) sheep1.clone();
        //浅复制时修改对象属性会影响复制的对象属性
        date.setTime(1234567L);

        System.out.println(sheep2);
    }
}
