package com.yay.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/2 10:15
 */
public class LockSupportTest1 {

    private static Thread mainThread;

    public static void main(String[] args) {
        // 获取主线程
        mainThread = Thread.currentThread();

        System.out.println(Thread.currentThread().getName() + " start ta");

        ThreadA ta = new ThreadA("ta");
        ta.start();


        System.out.println(Thread.currentThread().getName() + " block");
        LockSupport.park(mainThread);


        System.out.println(Thread.currentThread().getName() + " continue");
    }


    static class ThreadA extends Thread {
        ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wakeup others");
            LockSupport.unpark(mainThread);

        }
    }


}
