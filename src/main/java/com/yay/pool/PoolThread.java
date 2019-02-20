package com.yay.pool;

import org.apache.commons.lang3.RandomUtils;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/7/5 14:43
 */
public class PoolThread implements Runnable {

    private String name;

    public PoolThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try {
            System.out.println("【" + name + "】 is Running!" );
            Thread.sleep(RandomUtils.nextLong(0L,3000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
