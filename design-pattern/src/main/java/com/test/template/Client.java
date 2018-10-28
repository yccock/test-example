package com.test.template;

public class Client {

    public static void main(String[] args) {
        class DrawMony extends BankTemplateMethod {
            @Override
            public void transact() {
                System.out.println("取钱");
            }
        }

        DrawMony drawMony = new DrawMony();
        drawMony.process();
    }
}
