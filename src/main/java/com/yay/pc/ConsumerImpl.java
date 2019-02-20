package com.yay.pc;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 11:05
 */
public class ConsumerImpl extends AbstractConsumer {


    public ConsumerImpl(Queue<PcProduct> queue) {
        super(queue);
    }

    @Override
    public void consume(Queue<PcProduct> queue) {
        try {
            while(true) {

                PcProduct product = ((BlockingQueue<PcProduct>)queue).take();
                Thread.sleep(500 + (long) (Math.random() * 500));
                System.out.println("consume:" + product.getNo());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
