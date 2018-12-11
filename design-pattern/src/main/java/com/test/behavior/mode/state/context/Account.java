package com.test.behavior.mode.state.context;

import com.test.behavior.mode.state.state.AccountState;
import com.test.behavior.mode.state.state.NormalState;

/**
 * 银行账户：环境类
 */
public class Account {

    AccountState accountState;
    private String owner; //开启名
    private double balance = 0; //帐户余额

    public Account(String owner, double initCount) {
        this.accountState = new NormalState(this);
        this.owner = owner;
        this.balance = initCount;
        System.out.println(this.owner	+	"开户，初始金额为"	+	initCount);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountState(AccountState accountState) {
        this.accountState = accountState;
    }

    /**
     * 存款
     */
    public void deposite(double amount) {
        System.out.println(this.owner	+	"存款"	+	amount);
        accountState.deposite(amount);	//调用状态对象的deposit()方法
        System.out.println("现在余额为"+	this.balance);
        System.out.println("现在帐户状态为" + this.accountState.getClass().getSimpleName());
        System.out.println("-----------------------------");
    }

    /**
     * 取款
     */
    public void withdraw(double amount) {
        System.out.println(this.owner	+	"取款"	+	amount);
        accountState.withDraw(amount);	//调用状态对象的deposit()方法
        System.out.println("现在余额为"+	this.balance);
        System.out.println("现在帐户状态为" + this.accountState.getClass().getSimpleName());
        System.out.println("-----------------------------");
    }

    /**
     * 计算利息
     */
    public void computeInterest() {
        accountState.computeInterest();	//调用状态对象的computeInterest()方法
    }
}
