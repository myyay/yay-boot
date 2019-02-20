package com.yay.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/2 14:06
 */
public class CountDownLatchTest1 {


    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {
        doneSignal = new CountDownLatch(LATCH_SIZE);

        for (int i = 0; i < LATCH_SIZE; i++) {
            new InnerThread().start();
        }

        System.out.println("main wait begin");
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main await finished.");


    }


    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                doneSignal.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
