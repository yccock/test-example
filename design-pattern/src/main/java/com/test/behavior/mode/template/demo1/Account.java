package com.test.behavior.mode.template.demo1;

/**
 * ：账户类，充当抽象类
 */
public abstract class Account {

    /**
     * 校验
     */
    public boolean validate(String account, String password) {
        System.out.println(String.format("account:%s, password:%s", account, password));
        if (account.equals("test") && password.equals("123456")) {
            return true;
        }
        return false;
    }

    /**
     * 计算利息
     */
    public abstract void calculteInterest();

    public void display() {
        System.out.println("显示利息");
    }

    /**
     * 处理流程
     */
    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("用户名或密码错误");
            return;
        }
        calculteInterest();
        display();
    }
}
