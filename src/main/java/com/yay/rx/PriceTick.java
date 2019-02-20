package com.yay.rx;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述: 价格提示
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/21 15:05
 */
public class PriceTick {

    private final int sequence;
    private final Date date;
    private final String instrument;
    private final double price;

    public final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public PriceTick(int sequence, Date date, String instrument, double price) {
        this.sequence = sequence;
        this.date = date;
        this.instrument = instrument;
        this.price = price;
    }


    public int getSequence() {
        return sequence;
    }

    public Date getDate() {
        return date;
    }

    public String getInstrument() {
        return instrument;
    }

    public double getPrice() {
        return price;
    }


    public boolean isLast() {
        return sequence > 10;
    }

}
