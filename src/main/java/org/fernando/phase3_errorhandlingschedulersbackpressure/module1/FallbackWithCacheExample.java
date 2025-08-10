package org.fernando.phase3_errorhandlingschedulersbackpressure.module1;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

/*
* How it works
Main Source → Simulated remote service throws an exception.
onErrorResume() intercepts the error.
Fallback → Mono.justOrEmpty(Optional.ofNullable(CACHED_BOOK)) emits the cached value if present.
User Experience → The stream completes successfully, even though the main source failed.
*
* Key benefits of this approach:
User still gets a valid response.
The app avoids failing the whole request due to a temporary outage.
The fallback source can be memory, disk, or another service.
Non-blocking in real apps — the .block() here is only for main() demo purposes.
*
* */

public class FallbackWithCacheExample {
    //* Simulated "cached" value from memory/disk
    private static final String CACHED_BOOK = "Clean Code (cached)";

    public static void main(String[] args) {
        System.out.println("=== Fallback with Cached Data ===");
        //* Simulated remote service call
        Mono<String> remoteService = Mono.<String>fromCallable(() -> {
                    System.out.println("Calling remote service...");
                    Thread.sleep(500); //* simulate network delay
                    throw new RuntimeException("Remote service unavailable");
                })
                .timeout(Duration.ofSeconds(2));

        Mono<String> result = remoteService
                .onErrorResume(error -> {
                    System.out.println("Main source failed: " + error.getMessage());
                    //* Serve stale-but-safe value if available
                    return Mono.justOrEmpty(Optional.ofNullable(CACHED_BOOK));
                });

        //* Block for demo purposes so main() doesn't exit early
        String finalValue = result.block();
        System.out.println("Final value served to user: " + finalValue);
    }
}
