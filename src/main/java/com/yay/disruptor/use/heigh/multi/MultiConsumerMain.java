package com.yay.disruptor.use.heigh.multi;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.BasicExecutor;
import com.lmax.disruptor.dsl.ProducerType;
import com.yay.disruptor.common.DataDto;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadFactory;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 15:47
 */
public class MultiConsumerMain {

    public static void main(String[] args) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("my-%d").setDaemon(true).build();

        //Disruptor<DataDto> disruptor = new Disruptor<>(DataDto::new, 16, threadFactory, ProducerType.MULTI, new YieldingWaitStrategy());

        RingBuffer<DataDto> ringBuffer = RingBuffer.create(ProducerType.MULTI, DataDto::new, 16, new YieldingWaitStrategy());


        //2 通过ringBuffer 创建一个屏障
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();

        //3 创建多个消费者数组:
        Consumer[] consumers = new Consumer[10];
        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Consumer("C" + i);
        }

        //4 构建多消费者工作池
        WorkerPool<DataDto> workerPool = new WorkerPool<>(
                ringBuffer,
                sequenceBarrier,
                new EventExceptionHandler(),
                consumers
        );

        //5 设置多个消费者的sequence序号 用于单独统计消费进度, 并且设置到ringBuffer中
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());

        //6 启动workerPool
        workerPool.start(new BasicExecutor(threadFactory));

        final CountDownLatch latch = new CountDownLatch(1);
        //生产数据
        for (int i = 0; i < 100; i++) {
            final int myI = i;
            final Producer producer = new Producer("p" + i, ringBuffer);

            new Thread(() -> {
                try {
                    latch.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 100; j++) {

                    producer.sendData((myI + 10) * 1000 + j,myI + "-" + j);
                }
            }).start();
        }


        Thread.sleep(2000);
        System.err.println("----------线程创建完毕，开始生产数据----------");
        latch.countDown();

        Thread.sleep(10000);



        System.err.println("任务总数:" + consumers[2].getCount());




    }


    static class EventExceptionHandler implements ExceptionHandler<DataDto> {
        @Override
        public void handleEventException(Throwable ex, long sequence, DataDto event) {
            ex.printStackTrace();
        }

        @Override
        public void handleOnStartException(Throwable ex) {
            ex.printStackTrace();

        }

        @Override
        public void handleOnShutdownException(Throwable ex) {
            ex.printStackTrace();

        }
    }

}
