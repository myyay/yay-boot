package com.yay.pc;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/31 11:25
 */
public abstract class AbstractProducer implements PcProducer, Runnable {


    protected static final AtomicInteger INCR_PRODUCT_NO = new AtomicInteger(0);


    private final Queue<PcProduct> queue;

    protected AbstractProducer(Queue<PcProduct> queue) {
        this.queue = queue;
    }




    @Override
    public void run() {

        produce(queue);


    }
}
