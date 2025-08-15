package org.fernando.phase3_errorhandlingschedulersbackpressure.module1_errorhandling;

import reactor.core.publisher.Flux;

public class RecoverableErrorExample1 {
    public static void main(String[] args) {
//        System.out.println("=== onErrorResume() Example === provide a fallback stream");
//        Flux<String> resumeExample = Flux.just("Clean Code", "Reactive Spring")
//                .concatWith(Flux.error(new RuntimeException("Database unavailable")))
//                .onErrorResume(error -> {
//                    System.err.println("Recovering from error: " + error.getMessage());
//                    return Flux.just("Fallback Book 1", "Fallback Book 2");
//                });
//
//        resumeExample.subscribe(
//                value -> System.out.println("Subscriber received: " + value),
//                error -> System.out.println("Subscriber error: " + error.getMessage()),
//                () -> System.out.println("Subscriber complete")
//        );

        System.out.println("\n=== onErrorReturn() Example === emit a default value");
        Flux<String> returnExample = Flux.just("Clean Code", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("API timeout")))
                .onErrorReturn("Default Book");

        returnExample.subscribe(
                value -> System.out.println("Subscriber received: " + value),
                error -> System.out.println("Subscriber error: " + error.getMessage()),
                () -> System.out.println("Subscriber complete")
        );
    }
}
