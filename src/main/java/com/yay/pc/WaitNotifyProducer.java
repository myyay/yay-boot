package com.yay.pc;

import java.util.Queue;

import static com.yay.pc.WaitNotifyModel.LOCK;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 14:15
 */
public class WaitNotifyProducer extends AbstractProducer {

    private int cap;

    protected WaitNotifyProducer(Queue<PcProduct> queue, int cap) {
        super(queue);
        this.cap = cap;
    }

    @Override
    public void produce(Queue<PcProduct> queue) {

        while (true) {
            synchronized (LOCK) {
                try {
                    while (queue.size() == cap) {
                        LOCK.wait();
                    }

                    Thread.sleep((long) (Math.random() * 1000));
                    PcProduct product = new PcProduct(INCR_PRODUCT_NO.incrementAndGet());
                    System.out.println("Thread:" + Thread.currentThread().getName() + "produce: " + product.getNo());
                    queue.offer(product);
                    LOCK.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
