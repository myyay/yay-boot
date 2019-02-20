package com.yay.pc;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 11:05
 */
public class ProducerImpl extends AbstractProducer {

    public ProducerImpl(BlockingQueue<PcProduct> queue) {
        super(queue);
    }

    @Override
    public void produce(Queue<PcProduct> queue) {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                PcProduct product = new PcProduct(INCR_PRODUCT_NO.incrementAndGet());
                System.out.println("produce: " + product.getNo());
                ((BlockingQueue<PcProduct>)queue).put(product);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
