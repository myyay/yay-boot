package com.yay.disruptor.use.compare;

import com.yay.disruptor.common.DataDto;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描述: 测试阻塞队列遥速度
 * @author yangyang26
 * @version 1.0
 * @since 2019/2/21 15:31
 */
public class ArrayBlockingQueueTest {
    /** 1亿    总处理时间:24572ms */
    public static final int ONE_HUNDRED_MILLION = 100000000;
    public static final int FIFTY_MILLION = 50000000;
    public static final int TEN_MILLION = 10000000;
    /** 10亿 */
    public static final int ONE_BILLION = 1000000000;


    public static void main(String[] args) {


        final int size = ONE_HUNDRED_MILLION;

        final ArrayBlockingQueue<DataDto> queue = new ArrayBlockingQueue<>(size);
        final long startTime = System.currentTimeMillis();
        //生产者
        new Thread(() -> {
            long i = 0;
            //往队列里加数
            while (i < size) {
                DataDto data = new DataDto(i, "c" + i);
                try {
                    queue.put(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

        }).start();
        //消费者
        new Thread(() -> {

            long k = 0;


            //从队列里取数
            while (k < size) {

                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                k++;
            }

            //消费完了
            long endTime = System.currentTimeMillis();

            System.out.println("消费完了,总处理时间:" + (endTime - startTime) + "ms");
            System.out.println("queue Size:" + queue.size());


        }).start();


        System.out.println("线程启动完成");
    }

    //


}
