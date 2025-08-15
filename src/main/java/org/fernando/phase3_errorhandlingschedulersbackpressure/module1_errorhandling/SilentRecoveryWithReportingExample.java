package org.fernando.phase3_errorhandlingschedulersbackpressure.module1_errorhandling;

import reactor.core.publisher.Mono;

import java.time.Duration;

/*
* How it works
Main source fails → Simulated remote call throws an exception.
doOnError() → Logs the failure (could also send to monitoring/metrics system).
onErrorResume() → Returns a safe fallback value so the subscriber sees a normal result.
User unaffected → The fallback value is served without breaking the flow.
* */

public class SilentRecoveryWithReportingExample {
    public static void main(String[] args) {
        System.out.println("=== Silent Recovery with Reporting ===");

        Mono<String> remoteService = Mono.<String>fromCallable(() -> {
                    System.out.println("Calling remote service");
                    Thread.sleep(500); //* simulate delay
                    throw new RuntimeException("Remote service timeout");
                })
                .timeout(Duration.ofSeconds(2));

        Mono<String> result = remoteService
                .doOnError(error -> {
                    //* Reporting step: log the error, send metrics, etc
                    System.err.println("[REPORT] Error occurred: " + error.getMessage());
                })
                .onErrorResume(error -> {
                    //* Silent recovery: provide fallback so user is unaffected
                    System.out.println("[RECOVERY] Providing fallback data");
                    return Mono.just("Fallback value from cache");
                });

        //* Just for demo purposes
        String finalValue = result.block();
        System.out.println("Final value served to user: " + finalValue);
    }
}
