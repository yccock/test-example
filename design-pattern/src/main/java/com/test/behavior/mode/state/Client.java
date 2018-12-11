package com.test.behavior.mode.state;

import com.test.behavior.mode.state.context.Account;

/**
 * 为某银行开发一套信用卡业务系统，银行账户(Account)是该系统的核心类之 一，通过分析，账户存在三种状态，
 * 且在不同状态 下账户存在不同的行为，具体说明如下：
 *  (1)	如果账户中余额大于等于0，则账户的状态为正常状态(Normal	State)，此时用户既可以向该 账户存款也可以从该账户取款；
 *  (2)	如果账户中余额小于0，并且大于-2000，则账户的状态为透支状态(Overdraft State)，此时 用户既可以向该账户存款也
 *      可以从该账户取款，但需要按天计算利息；
 *  (3)	如果账户中余额等于-2000，那么账户的状态为受限状态(Restricted State)，此时用户只能向
 *      该账户存款，不能再从中取款，同时也将按天计算利息；
 *  (4)	根据余额的不同，以上三种状态可发生相互转换。
 *
 *  Account充当环境类角色，AccountState充当抽象状态角色，NormalState、 OverdraftState和RestrictedState充当具体状态角色
 */
public class Client {

    public static void main(String[] args) {
        Account account = new Account("张三", 0.0);
        account.deposite(1000);
        account.deposite(2000);
        account.withdraw(3000);
        account.withdraw(1000);
        account.withdraw(1000);
        account.computeInterest();
    }
}
