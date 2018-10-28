package com.test.thread.sync;

public class MultiThread2 extends Thread{

    private int count = 5;

    public synchronized void run(){
        System.out.println(this.currentThread().getName() + " count=" + count);
    }

    public static void main(String[] args) {
        MultiThread2 multiThread = new MultiThread2();

        Thread t1 = new Thread(multiThread);
        Thread t2 = new Thread(multiThread);
        Thread t3 = new Thread(multiThread);
        Thread t4 = new Thread(multiThread);
        Thread t5 = new Thread(multiThread);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
