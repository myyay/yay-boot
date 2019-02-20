package com.yay.rx;


import com.yay.utils.DateUtils;
import io.reactivex.Observable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.yay.utils.DateUtils.FORMAT_DATETIME;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/14 16:48
 */
public class RxJavaTest {

    public static void main(String[] args) throws InterruptedException {

        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dogs"
        );

        /*Observable.fromIterable(words)
                .zipWith(Observable.range(1, Integer.MAX_VALUE),
                        (string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);*/
        /*Observable.fromIterable(words)
                .flatMap(word -> Observable.fromIterable(Arrays.asList(word.split(""))))
                .distinct()
                .sorted()
                .zipWith(Observable.range(1, Integer.MAX_VALUE),(string, count) -> String.format("%2d. %s", count, string))
                .subscribe(System.out::println);*/


        Observable<Long> fast = Observable.interval(1, TimeUnit.SECONDS);
        Observable<Long> slow = Observable.interval(3, TimeUnit.SECONDS);

        Observable<Long> clock = Observable.merge(slow.filter(tick -> isSlowTime()), fast.filter(tick -> !isSlowTime()));

        clock.subscribe(tick -> System.out.println(DateUtils.formatDate(new Date(), FORMAT_DATETIME)));

        Thread.sleep(60_000);

    }


    private static boolean isSlowTickTime() {
        return LocalDate.now().getDayOfWeek() == DayOfWeek.SATURDAY ||
                LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private static long start = System.currentTimeMillis();


    private static boolean isSlowTime() {
        return (System.currentTimeMillis() - start) % 30_000 >= 15_000;
    }
}
