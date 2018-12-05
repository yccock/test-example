package com.test.facade;


public class Client {

    public static void main(String[] args) {

        Facade facade = new Facade();
        facade.register();
        facade.treat();
        facade.pay();
        facade.getDrug();
    }
}
