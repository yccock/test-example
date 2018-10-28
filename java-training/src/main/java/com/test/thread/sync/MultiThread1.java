package com.test.thread.sync;

/**
 * 关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁
 * 所以代码中哪个纯种先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁
 *
 * 在静态方法上加synchronized，表示锁定.class类，类一级别的锁（独占.class类）
 */
public class MultiThread1 {

    private static int num = 0;

    public synchronized void printNum(String tag){
        try {
            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over");
            }
            System.out.println("tag " + tag + ", num=" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiThread1 m1 = new MultiThread1();
        MultiThread1 m2 = new MultiThread1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();
    }
}
