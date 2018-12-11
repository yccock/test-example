package com.test.behavior.mode.state.state;

import com.test.behavior.mode.state.context.Account;

/**
 * 透支状态：具体状态
 */
public class OverdraftState extends AccountState{

    public OverdraftState(AccountState accountState) {
        this.account = accountState.account;
    }

    public OverdraftState(Account account) {
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
        System.out.println("透支，计算利息！");
    }

    @Override
    public void stateCheck() {
        double balance = account.getBalance();
        if (balance > 0) {
            account.setAccountState(new NormalState(this));
        } else if (balance == -2000) {
            account.setAccountState(new RestrictedState(this));
        } else if (balance < -2000) {
            System.out.println("操作受限");
        }
    }
}
