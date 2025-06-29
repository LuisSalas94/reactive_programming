package org.fernando.phase1_fundamentals.module3_reactivestreams;

import reactor.core.publisher.Flux;

public class SignalLifecycleExample {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("Maria", "Claudia", "Gozde")
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe"))
                .doOnNext(item -> System.out.println("doOnNext: " + item))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnError(error -> System.out.println("doOnError: " + error.getMessage()));

        flux.subscribe(
                s -> {
                },
                error -> {
                },
                () -> System.out.println("Completed")

        );


    }
}
