package com.yay.rx;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: 数据源
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/21 15:04
 */
public class SomeFeed {

    private AtomicInteger threadcounter = new AtomicInteger(1);
    private ExecutorService service = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("Thread " + threadcounter.getAndIncrement());
                return thread;
            });

    private volatile boolean running = true;

    private List<SomeListener> listeners = new LinkedList<>();

    private int threadCount;

    private static final String[] instruments = {"IBM", "NMR", "BAC", "AAPL", "MSFT"};
    private static final double[] prices = {160, 5, 15, 108, 57};

    private static final Random RANDOM_PRICE = new Random(0);
    AtomicInteger sequence = new AtomicInteger(1);




    public SomeFeed() {
        this(instruments.length);
    }

    public SomeFeed(int threadCount) {
        this(threadCount, false);
    }

    public SomeFeed(int threadCount, boolean barriered) {
        this.threadCount = threadCount;
        /*this.barriered = barriered;
        if (barriered) {
            barrier = new CyclicBarrier(threadCount, System.out::println);
        }*/
        launchPublishers();
    }

    void launchPublishers() {
        System.out.println("launch...");
        for (int i = 0; i < threadCount; i++) {
            launchEventThread(instruments[i % instruments.length], prices[i % prices.length]);
        }
    }

    private void launchEventThread(String instrument, double startingPrice) {
        service.execute(() -> {
            double price = startingPrice;
            while (running) {
                price += RANDOM_PRICE.nextGaussian();
                double finalPrice = price;
                listeners.forEach(subscriber -> {
                    PriceTick tick = new PriceTick(sequence.getAndIncrement(), new Date(), instrument, finalPrice);
                    subscriber.priceTick(tick);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    public void terminate() {
        running = false;
    }

}
