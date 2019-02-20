package com.yay.pc;

import java.util.Queue;

/**
 * 描述: 消费者
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/31 11:18
 */
public interface PcConsumer {

    void consume(Queue<PcProduct> queue);
}
