package com.yay.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2017/11/7 15:17
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    /** 时间格式. */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    /** 全时间格式. */
    public static final String FORMAT_FULLTIME = "yyyyMMddHHmmss";
    /** 日期格式. */
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    /** 日期格式. */
    public static final String FORMAT_DAY = "yyyyMMdd";
    /** 日期格式. */
    public static final String FORMAT_MONTH = "yyyyMM";
    /** 纯时间格式. */
    public static final String FORMAT_TIME = "HH:mm:ss";

    /** 得到给定日期的日期字符串 默认格式（yyyyMMddHHmmss） */
    public static String formatDate(Date date, String... pattern) {
        String formatDate;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0]);
        } else {
            formatDate = DateFormatUtils.format(date, FORMAT_FULLTIME);
        }
        return formatDate;
    }

    /**
     * 日期型字符串转化为日期 格式
     * <p/>
     * { "yyyyMMddHHmmss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss",
     * "yyyyMMdd", "yyyy-MM-dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(),
                    FORMAT_FULLTIME, FORMAT_DATE, FORMAT_DATETIME, FORMAT_DAY);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 指定类型转换
     * @param str    时间
     * @param format 模版
     * @return Date
     */
    public static Date parseDate(String str, String format) {
        if (str == null) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(str, format);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static Date getZeroDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
