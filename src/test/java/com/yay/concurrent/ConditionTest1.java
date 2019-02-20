package com.yay.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/10/31 18:40
 */
public class ConditionTest1 {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");

        lock.lock(); // 获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " start ta");
            ta.start();

            System.out.println(Thread.currentThread().getName() + " block");
            System.out.println(" 1." + lock.isLocked());
            condition.await();    // 等待
            System.out.println(" 2." + lock.isLocked());

            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(" 4." + lock.isLocked());

            lock.unlock();    // 释放锁
            System.out.println(" 5." + lock.isLocked());

        }
    }

    static class ThreadA extends Thread {

        ThreadA(String name) {
            super(name);
        }

        public void run() {
            System.out.println(" 3." + lock.isLocked());
            lock.lock();    // 获取锁
            try {
                System.out.println(lock.getHoldCount());
                System.out.println(Thread.currentThread().getName() + " wakup others");
                condition.signal();    // 唤醒“condition所在锁上的其它线程”
            } finally {
                lock.unlock();    // 释放锁
            }
        }
    }
}
