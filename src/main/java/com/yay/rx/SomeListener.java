package com.yay.rx;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/21 15:15
 */
public abstract class SomeListener {

    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final int ID;

    public SomeListener() {
        ID = COUNTER.getAndIncrement();
    }


    public abstract void priceTick(PriceTick event);

    public abstract void error(Throwable t);


}
