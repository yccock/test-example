package com.test.behavior.mode.visitor.visitor;

import com.test.behavior.mode.visitor.element.FulltimeEmployee;
import com.test.behavior.mode.visitor.element.ParttimeEmployee;

/**
 * 部门类：抽象访问者类
 */
public abstract class Department {

    //声明一组重载的访问方法，用于访问不同类型的具体元素

    public abstract void visit(FulltimeEmployee fulltimeEmployee);

    public abstract void visit(ParttimeEmployee parttimeEmployee);
}
