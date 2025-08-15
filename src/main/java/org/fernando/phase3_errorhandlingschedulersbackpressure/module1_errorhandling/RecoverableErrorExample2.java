package org.fernando.phase3_errorhandlingschedulersbackpressure.module1_errorhandling;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class RecoverableErrorExample2 {
    public static void main(String[] args) {
//        System.out.println("=== retry() Example === try the operation again");
//        Mono<String> retryExample = Mono.<String>fromCallable(() -> {
//                    System.out.println("Attempting operation...");
//                    throw new RuntimeException("Temporary network issue");
//                })
//                .retry(2) //* retry twice before failing
//                .onErrorReturn("Recovery after retries");
//
//        retryExample.subscribe(
//                value -> System.out.println("Subscriber received: " + value),
//                error -> System.out.println("Subscriber error: " + error.getMessage()),
//                () -> System.out.println("Subscriber complete")
//        );

        System.out.println("\n=== timeout() Example === fail fast if something takes too long");
        String result = Mono.just("Data from slow service")
                .delayElement(Duration.ofSeconds(2)) //* simulate slow operation
                .timeout(Duration.ofSeconds(1))
                .onErrorReturn("Timeout fallback value")
                .block();

        System.out.println("Subscriber received: " + result);

    }
}

