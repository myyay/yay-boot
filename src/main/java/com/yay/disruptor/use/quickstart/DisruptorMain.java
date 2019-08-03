package com.yay.disruptor.use.quickstart;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.yay.disruptor.common.DataDto;
import com.yay.disruptor.common.DataDtoEventHandler;
import com.yay.disruptor.common.DataDtoProducer;

import java.util.concurrent.ThreadFactory;

/**
 * 描述: quickstart测试
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/26 16:53
 */
public class DisruptorMain {

    public static void main(String[] args) {

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my-%d").setDaemon(true).build();

        //eventFactory   the factory to create events in the ring buffer.
        //ringBufferSize the size of the ring buffer, must be power of 2.
        //threadFactory  a {@link ThreadFactory} to create threads for processors.
        //producerType   the claim strategy to use for the ring buffer.
        //waitStrategy   the wait strategy to use for the ring buffer.
        Disruptor<DataDto> disruptor = new Disruptor<>(
                DataDto::new,
                16,
                threadFactory,
                ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );


        disruptor.handleEventsWith(new DataDtoEventHandler());

        disruptor.start();


        DataDtoProducer producer = new DataDtoProducer(disruptor.getRingBuffer());
        for (int i = 0; i < 100; i++) {
            DataDto dataDto = new DataDto();
            dataDto.setId((long) i);
            dataDto.setDesc("描述:" + i);
            producer.sendData1(dataDto);
        }


        disruptor.shutdown();


    }


}
