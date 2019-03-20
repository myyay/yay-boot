package com.yay.disrupter.common;

import com.lmax.disruptor.EventHandler;

/**
 * 描述: disruptor完成任务后，清除ringBuffer数据
 * @author yangyang26
 * @version 1.0
 * @since 2019/2/21 20:17
 */
public class ClearEventHandler<DataDto> implements EventHandler<DataDto> {
    @Override
    public void onEvent(DataDto event, long sequence, boolean endOfBatch) throws Exception {

        event = null;

    }
}
