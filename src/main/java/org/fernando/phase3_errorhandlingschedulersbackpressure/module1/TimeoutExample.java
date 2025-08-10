package org.fernando.phase3_errorhandlingschedulersbackpressure.module1;

import reactor.core.publisher.Mono;

import java.time.Duration;

/*
 * How it works
 * Slow Service → Takes 3 seconds to respond.
 * timeout(2s) → Cancels the operation after 2 seconds and sends a TimeoutException.
 * onErrorResume() → Catches the timeout error and returns a safe fallback.
 * Result → The user still gets valid data without long waits.
 */


public class TimeoutExample {
    public static void main(String[] args) {
        System.out.println("=== Timeout with Graceful Failure ===");
        //* Simulate a slow external service
        Mono<String> slowService = Mono.fromCallable(() -> {
            System.out.println("Calling external service...");
            Thread.sleep(300);
            return "Fresh data from service";
        });

        //* Apply timeout and recovery
        Mono<String> result = slowService
                .timeout(Duration.ofSeconds(2)) //* Fail if it takes more than 2 seconds
                .onErrorResume(error -> {
                    System.err.println("Operation timed out: " + error.getMessage());
                    System.out.println("Recovering with fallback value...");
                    return Mono.just("Fallback data from cache");
                });

        //* Block for demo purposes
        String finalValue = result.block();
        System.out.println("Final value served to user: " + finalValue);
    }
}
