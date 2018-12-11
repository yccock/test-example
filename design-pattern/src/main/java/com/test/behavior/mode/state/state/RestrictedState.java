package com.test.behavior.mode.state.state;

import com.test.behavior.mode.state.context.Account;

/**
 * 受限状态：具体状态类
 */
public class RestrictedState extends AccountState {

    public RestrictedState(AccountState accountState) {
        this.account = accountState.account;
    }

    public RestrictedState(Account account) {
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
        System.out.println("受限，计算利息！");
    }

    @Override
    public void stateCheck() {
        double balance = account.getBalance();
        if (balance > 0) {
            account.setAccountState(new NormalState(this));
        } else if (balance > -2000) {
            account.setAccountState(new OverdraftState(this));
        }
    }
}
