package com.test.behavior.mode.visitor.element;

import com.test.behavior.mode.visitor.visitor.Department;

/**
 * 员工类：抽象元素类
 */
public interface Employee {

    public void accept(Department department); //接受一个抽象访问者访问
}
