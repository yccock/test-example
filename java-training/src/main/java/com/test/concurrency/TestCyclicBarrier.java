package com.test.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * http://scau-fly.iteye.com/blog/1955165
 */
public class TestCyclicBarrier {

    public static final int threadNum = 3;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        executorService.submit(new Worker("zhangsan", cyclicBarrier));
        executorService.submit(new Worker("lishi", cyclicBarrier));
        executorService.submit(new Worker("wangwu", cyclicBarrier));
        executorService.shutdown();
    }

    static class Worker implements Runnable {

        private String name;

        private CyclicBarrier cyclicBarrier;

        public Worker(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(8));
                System.out.println(sdf.format(new Date()) + " " + name + "准备完成");
                cyclicBarrier.await();
                System.out.println(sdf.format(new Date()) + " " + name + "执行任务");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

}
