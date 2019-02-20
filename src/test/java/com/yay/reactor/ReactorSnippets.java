package com.yay.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: XXX
 * @author yangyang26
 * @version 1.0
 * @since 2018/5/23 18:17
 */
public class ReactorSnippets {

    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );


    @Test
    public void simpleCreation() {

        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);

        System.out.println("=====================================");

        manyWords.subscribe(System.out::println);


    }

    @Test
    public void findingMissingLetter() {

        Flux<String> manyLetters = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (letter, index) -> String.format("%d. %s", index, letter));

        manyLetters.subscribe(System.out::println);


    }

    @Test
    public void restoringMissingLetter() {

        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux.fromIterable(words)
                .flatMap(word -> Flux.fromArray(word.split("")))
                .distinct()
                .concatWith(missing)
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (letter, index) -> String.format("%d. %s", index, letter));


        allLetters.subscribe(System.out::println);


    }

    @Test
    public void shortCircuit() {
        Flux<String> hello = Flux.just("Hello")
                .concatWith(Flux.just("World").delaySubscription(Duration.ofMillis(2000)));

        hello.subscribe(System.out::println);

        Flux<String> hello2 = Mono.just("Hello")
                .concatWith(Mono.just("World").delaySubscription(Duration.ofMillis(500)));

        hello2.toStream().forEach(System.out::println);

        Mono<String> a = Mono.just("oops I'm late")
                .delaySubscription(Duration.ofMillis(500));
        Flux<String> b = Flux.just("let's get", "the party", "started");
        Flux.first(a, b).toIterable().forEach(System.out::println);

    }

}
