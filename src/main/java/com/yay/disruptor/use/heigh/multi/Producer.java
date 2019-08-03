package com.yay.disruptor.use.heigh.multi;

import com.lmax.disruptor.RingBuffer;
import com.yay.disruptor.common.DataDto;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2019/4/30 18:42
 */
public class Producer {

    private String name;

    private RingBuffer<DataDto> ringBuffer;

    public Producer(String name, RingBuffer<DataDto> ringBuffer) {
        this.name = name;
        this.ringBuffer = ringBuffer;
    }

    public void sendData(long id, String uuid) {
        long sequence = ringBuffer.next();
        try {
            DataDto dataDto = ringBuffer.get(sequence);
            dataDto.setId(id);
            dataDto.setDesc(name + " : " + uuid);
        } finally {
            ringBuffer.publish(sequence);
        }

    }

}
