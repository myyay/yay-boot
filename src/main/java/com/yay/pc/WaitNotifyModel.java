package com.yay.pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/6/1 13:38
 */
public class WaitNotifyModel {
    Queue<PcProduct> queue = new LinkedList<>();

    public static final Object LOCK = new Object();


    public static void main(String[] args) {
        int cap = 3;
        WaitNotifyModel model = new WaitNotifyModel();
        for (int i = 0; i < 3; i++) {
            new Thread(new WaitNotifyProducer(model.queue, cap)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new WaitNotifyConsumer(model.queue)).start();
        }

    }


}
