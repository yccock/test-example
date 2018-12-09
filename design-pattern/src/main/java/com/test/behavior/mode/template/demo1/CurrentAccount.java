package com.test.behavior.mode.template.demo1;

/**
 * 活期计算利息方法
 */
public class CurrentAccount extends Account{
    @Override
    public void calculteInterest() {
        System.out.println("按活期利率计算利息！");
    }
}
