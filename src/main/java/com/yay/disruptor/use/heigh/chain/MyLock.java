package com.yay.disruptor.use.heigh.chain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 16:47
 */
public class MyLock {
    private static Lock lock = new ReentrantLock();

    public static void lock() {
        lock.lock();
    }


    public static void unlock() {
        lock.unlock();
    }
}
