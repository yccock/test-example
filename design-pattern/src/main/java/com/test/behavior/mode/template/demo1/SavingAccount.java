package com.test.behavior.mode.template.demo1;

/**
 * 定期计算利息方法
 */
public class SavingAccount extends Account {
    @Override
    public void calculteInterest() {
        System.out.println("按定期利率计算利息！");
    }
}
