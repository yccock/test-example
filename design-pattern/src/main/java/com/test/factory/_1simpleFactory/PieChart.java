package com.test.factory._1simpleFactory;

/**
 * 饼图
 */
public class PieChart implements Chart{

    public PieChart() {
        System.out.println("创建饼图");
    }

    @Override
    public void display() {
        System.out.println("显示饼图");
    }
}
