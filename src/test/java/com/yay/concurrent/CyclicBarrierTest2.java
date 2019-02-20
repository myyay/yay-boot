package com.yay.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/2 14:31
 */
public class CyclicBarrierTest2 {

    private static CyclicBarrier cb;
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {

        cb = new CyclicBarrier(5, () -> System.out.println("CyclicBarrier's parties is: " + cb.getParties()));

        for (int i = 0; i < 5; i++) {
            new InnerThread().start();
        }

        countDownLatch.await();

        for (int i = 0; i < 5; i++) {
            new InnerThread().start();
        }

    }


    static class InnerThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
            try {
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " continued.");

            countDownLatch.countDown();
        }
    }
}
