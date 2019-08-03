package com.yay.disruptor.use.heigh.chain;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.yay.disruptor.common.DataDto;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 14:02
 */
public class DataDtoEventHandler5 implements EventHandler<DataDto>, WorkHandler<DataDto> {
    @Override
    public void onEvent(DataDto event, long sequence, boolean endOfBatch) throws Exception {
        Thread.sleep(event.getId() * 10);
        MyLock.lock();
        event.setDesc(event.getDesc() + " -> Handler5");
        System.out.println(Thread.currentThread().getName() + "(" + this.getClass().getSimpleName() + ")" + " : " + sequence + " : " + event);
        MyLock.unlock();


    }


    @Override
    public void onEvent(DataDto event) throws Exception {
        onEvent(event, -1L, false);
    }
}
