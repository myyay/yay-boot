package com.yay.pc;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/31 11:25
 */
public abstract class AbstractConsumer implements PcConsumer, Runnable {

    private final Queue<PcProduct> queue;

    protected AbstractConsumer(Queue<PcProduct> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        consume(queue);

    }

}
