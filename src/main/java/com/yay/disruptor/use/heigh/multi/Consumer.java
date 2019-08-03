package com.yay.disruptor.use.heigh.multi;

import com.lmax.disruptor.WorkHandler;
import com.yay.disruptor.common.DataDto;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 18:20
 */
public class Consumer implements WorkHandler<DataDto> {

    private String comsumerId;

    private static AtomicInteger count = new AtomicInteger(0);

    private Random random = new Random();

    public Consumer(String comsumerId) {
        this.comsumerId = comsumerId;
    }

    @Override
    public void onEvent(DataDto event) throws Exception {
        Thread.sleep(random.nextInt(5));
        System.err.println("当前消费者: " + this.comsumerId + ", 消费信息ID: " + event.getId() + ", 消费描述:" + event.getDesc());
        count.incrementAndGet();
    }


    public int getCount() {
        return count.get();
    }

}
