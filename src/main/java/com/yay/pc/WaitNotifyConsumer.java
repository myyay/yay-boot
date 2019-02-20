package com.yay.pc;

import java.util.Queue;

import static com.yay.pc.WaitNotifyModel.LOCK;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 13:43
 */
public class WaitNotifyConsumer extends AbstractConsumer {

    protected WaitNotifyConsumer(Queue<PcProduct> queue) {
        super(queue);
    }

    @Override
    public void consume(Queue<PcProduct> queue) {
        while (true) {
            synchronized (LOCK) {
                try {
                    while (queue.size() == 0) {
                        LOCK.wait();
                    }

                    PcProduct product = queue.poll();
                    Thread.sleep(500 + (long) (Math.random() * 500));
                    System.out.println("Thread:" + Thread.currentThread().getName() + "consume:" + product.getNo());


                    LOCK.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
