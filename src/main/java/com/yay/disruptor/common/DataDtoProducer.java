package com.yay.disruptor.common;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 14:23
 */
public class DataDtoProducer {

    private RingBuffer<DataDto> ringBuffer;

    private ByteBuffer byteBuffer;

    public DataDtoProducer(RingBuffer<DataDto> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void sendData(DataDto dataDto) {

    }

    public void sendData1(DataDto dataDto) {

        long sequence = ringBuffer.next();

        try {
            DataDto dataDto1 = ringBuffer.get(sequence);
            dataDto1.setId(dataDto.getId());
            dataDto1.setDesc(dataDto.getDesc());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }


    }

}
