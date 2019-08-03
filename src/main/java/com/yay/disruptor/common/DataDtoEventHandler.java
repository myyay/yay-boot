package com.yay.disruptor.common;

import com.lmax.disruptor.EventHandler;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 14:02
 */
public class DataDtoEventHandler implements EventHandler<DataDto> {
    @Override
    public void onEvent(DataDto event, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(event.getId() * 10);

        if (endOfBatch) {
            System.out.println(Thread.currentThread().getName() +": I am the end of batch :" + sequence);
        }

        System.out.println(Thread.currentThread().getName() +": " + sequence + " : " + event);


    }
}
