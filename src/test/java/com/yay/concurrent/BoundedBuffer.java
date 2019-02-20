package com.yay.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/1 19:34
 */
public class BoundedBuffer {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[5];

    int putPtr, takePtr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putPtr] = x;
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            ++count;
            notEmpty.signal();
            System.out.println(Thread.currentThread().getName() + " put " + x);

        } finally {
            lock.unlock();
        }
    }


    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            Object x = items[takePtr];
            if (++takePtr == items.length) takePtr = 0;
            --count;
            notFull.signal();
            System.out.println(Thread.currentThread().getName() + " take " + x);
            return x;
        } finally {
            lock.unlock();
        }
    }


}
