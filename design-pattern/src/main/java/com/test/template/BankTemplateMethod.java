package com.test.template;

public abstract class BankTemplateMethod {

    public void takeNumber(){
        System.out.println("拿号");
    }

    public abstract void transact();//具体的业务办理

    public void evaluate(){
        System.out.println("评分");
    }

    public final void process(){

        this.takeNumber();

        this.transact();

        this.transact();
    }
}
