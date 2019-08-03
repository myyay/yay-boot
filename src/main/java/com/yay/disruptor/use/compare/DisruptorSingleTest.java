package com.yay.disruptor.use.compare;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.yay.disruptor.common.DataDto;

import java.nio.ByteBuffer;

/**
 * 描述: Disruptor 单生产消费者测试
 * @author yangyang26
 * @version 1.0
 * @since 2019/2/21 16:16
 */
public class DisruptorSingleTest {

    /** 1亿   23028ms */
    public static final int ONE_HUNDRED_MILLION = 100000000;
    public static final int FIFTY_MILLION = 50000000;
    public static final int TEN_MILLION = 10000000;
    /** 10亿 */
    public static final int ONE_BILLION = 1000000000;

    public static int size;
    public static long startTime;


    public static void main(String[] args) {

        size = ONE_HUNDRED_MILLION;

        startTime = System.currentTimeMillis();

        // Specify the size of the ring buffer, must be power of 2.
        final int bufferSize = 65536;
        // Construct the Disruptor
        final Disruptor<DataDto> disruptor = new Disruptor<>(
                DataDto::new,
                bufferSize,
                DaemonThreadFactory.INSTANCE,
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );

        DateDtoConsumer4Test consumer4Test = new DateDtoConsumer4Test();

        // Connect the handler
        disruptor.handleEventsWith(consumer4Test);

        // Start the Disruptor, starts all threads running
        disruptor.start();

        System.out.println("消费者已启动");

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<DataDto> ringBuffer = disruptor.getRingBuffer();

        ByteBuffer bb = ByteBuffer.allocate(8);
        new Thread(() -> {
            for (long l = 0; l < size; l++) {
                bb.putLong(0, l);
                //填数据
                ringBuffer.publishEvent(DisruptorSingleTest::translate, bb);
            }
        }).start();
        /*new Thread(() -> {

            for (long i = 0; i < size; i++) {
                long seq = ringBuffer.next();

                try {
                    // Get the entry in the Disruptor
                    DataDto data = ringBuffer.get(seq);
                    // for the sequence
                    // Fill with data
                    data.setId(i);
                    data.setDesc("c" + i);
                } finally {
                    ringBuffer.publish(seq);
                }
            }
        }).start();*/

    }


    static class DateDtoConsumer4Test implements EventHandler<DataDto> {

        /** 只适用于单消费者 */
        private int i = 0;

        @Override
        public void onEvent(DataDto event, long sequence, boolean endOfBatch) throws Exception {

            if (++i >= size) {
                long endTime = System.currentTimeMillis();
                System.out.println("Disruptor costTime = " + (endTime - startTime) + "ms");
            }

        }
    }


    public static void translate(DataDto event, long sequence, ByteBuffer buffer) {
        event.setId(buffer.getLong(0));
        event.setDesc("c" + event.getId());
    }

/*
    public class LongEventProducerWitTranslator {
        private final RingBuffer<DataDto> ringBuffer;

        public LongEventProducerWithTranslator(RingBuffer<DataDto> ringBuffer) {
            this.ringBuffer = ringBuffer;
        }

        private final EventTranslatorTwoArg<DataDto, ByteBuffer> TRANSLATOR =
                (event, sequence, bb, bb2) -> {
                    event.setId(bb.getLong(0));
                    event.setDesc(bb.getDouble());
                };

        public void onData(ByteBuffer bb) {
            ringBuffer.publishEvent(TRANSLATOR, bb);
        }
    }*/

}
