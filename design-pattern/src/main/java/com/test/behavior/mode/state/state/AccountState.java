package com.test.behavior.mode.state.state;

import com.test.behavior.mode.state.context.Account;

/**
 * 抽象状态类
 */
public abstract class AccountState {

    protected Account account;

    /**
     * 存款
     */
    public abstract void deposite(double amount);

    /**
     * 取款
     */
    public abstract void withDraw(double amount);

    /**
     * 计算利息
     */
    public abstract void computeInterest();

    /**
     * 状态检查
     */
    public abstract void stateCheck();

}
