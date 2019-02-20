package com.yay.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/2 15:46
 */
public class SemaphoreTest1 {
    private static final int SEM_MAX = 10;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEM_MAX);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyThread(semaphore, 5));
        executorService.execute(new MyThread(semaphore, 4));
        executorService.execute(new MyThread(semaphore, 7));

        executorService.shutdown();
    }


    static class MyThread extends Thread {

        private volatile Semaphore sem;    // 信号量
        private int count;        // 申请信号量的大小

        MyThread(Semaphore sem, int count) {
            this.sem = sem;
            this.count = count;
        }


        @Override
        public void run() {
            try {
                sem.acquire(count);
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " acquire count=" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sem.release(count);
                System.out.println(Thread.currentThread().getName() + " release " + count + "");
            }
        }
    }


}
