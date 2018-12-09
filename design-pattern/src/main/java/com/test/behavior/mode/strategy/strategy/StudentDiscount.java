package com.test.behavior.mode.strategy.strategy;

/**
 * 学生票折扣类：具体策略类
 */
public class StudentDiscount implements IDiscount {
    @Override
    public double calculate(double price) {
        System.out.println("学生票：");
        return	price	*	0.8;
    }
}
