package com.test.behavior.mode.state.state;

import com.test.behavior.mode.state.context.Account;

/**
 * 正常状态：具体状态类
 */
public class NormalState extends AccountState{

    public NormalState(AccountState accountState) {
        this.account = accountState.account;
    }

    public NormalState(Account account) {
        this.account = account;
    }

    @Override
    public void deposite(double amount) {
        account.setBalance(account.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withDraw(double amount) {
        account.setBalance(account.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("正常状态，无须支付利息！");
    }

    @Override
    public void stateCheck() {
        double balance = account.getBalance();
        if (balance > -2000 && balance < 0) {
            account.setAccountState(new OverdraftState(this));
        } else if (balance == -2000) {
            account.setAccountState(new RestrictedState(this));
        } else if (balance < -2000) {
            System.out.println("操作受限");
        }
    }
}
