package com.yay.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 10:59
 */
public class BlockingQueueModel {

    private final BlockingQueue<PcProduct> queue;


    public BlockingQueueModel(int cap) {
        this.queue =  new LinkedBlockingQueue<>(cap);
    }




    public static void main(String[] args) {
        BlockingQueueModel model = new BlockingQueueModel(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new ConsumerImpl(model.queue)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new ProducerImpl(model.queue)).start();
        }



    }

}
