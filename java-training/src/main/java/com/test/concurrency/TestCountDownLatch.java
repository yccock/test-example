package com.test.concurrency;


import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static final int threadNum = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSingal = new CountDownLatch(1);
        CountDownLatch doneSingal = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Worker(i, startSingal, doneSingal)).start();
        }
        System.out.println("开始执行任务");
        //开始执行
        startSingal.countDown();
        //等待所有的线程执行完毕
        doneSingal.await();
        System.out.println("所有任务执行完成");

    }

    static class Worker implements Runnable {

        private CountDownLatch startSingal;
        private CountDownLatch doneSingal;
        private int index;

        public Worker(int index, CountDownLatch startSingal, CountDownLatch doneSingal) {
            this.startSingal = startSingal;
            this.doneSingal = doneSingal;
            this.index = index;
        }

        @Override
        public void run() {
            //等待开始执行信号的发布
            try {
                startSingal.await();
                for (int i = index; i < index + 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行任务" + index);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSingal.countDown();
            }
        }
    }

}
