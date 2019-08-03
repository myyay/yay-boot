package com.yay.disruptor.use.heigh.chain;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.yay.disruptor.common.DataDto;

import java.nio.ByteBuffer;
import java.util.concurrent.ThreadFactory;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 15:51
 */
public class ChainConsumerMain {


    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my-%d").setDaemon(true).build();


        Disruptor<DataDto> disruptor = new Disruptor<>(
                DataDto::new,
                16,
                threadFactory,
                ProducerType.SINGLE,
                new BlockingWaitStrategy()
        );


        DataDtoEventHandler1 h1 = new DataDtoEventHandler1();
        DataDtoEventHandler2 h2 = new DataDtoEventHandler2();
        DataDtoEventHandler3 h3 = new DataDtoEventHandler3();
        DataDtoEventHandler4 h4 = new DataDtoEventHandler4();
        DataDtoEventHandler5 h5 = new DataDtoEventHandler5();

        //disruptor.handleEventsWith(h1, h4);
        disruptor.handleEventsWithWorkerPool(h1, h4).then(h2, h5).then(h3);


        //disruptor.handleEventsWith(h1, h4);
        //disruptor.after(h1).handleEventsWith(h2);
        //disruptor.after(h4).handleEventsWith(h5);
        //disruptor.after(h2, h5).handleEventsWith(h3);


        disruptor.start();


        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; l < 1; l++) {
            bb.putLong(0, l);
            disruptor.publishEvent(ChainConsumerMain::translate, bb);
        }


        disruptor.shutdown();


        Thread.sleep(3000L);

    }


    public static void translate(DataDto event, long sequence, ByteBuffer buffer) {
        event.setId(buffer.getLong(0));
        event.setDesc("c" + event.getId());
    }


}
