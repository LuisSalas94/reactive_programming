package org.fernando.phase1_fundamentals.module5_reactiveerror;

import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryWhenExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger attemptCounter = new AtomicInteger(0);

        Flux<String> bookService = Flux.defer(() -> {
            int attempt = attemptCounter.incrementAndGet();
            if (attempt < 4) {
                System.out.println("Attempt: " + attempt + ": Service unavailable");
                return Flux.error(new RuntimeException("Temporary failure"));
            } else {
                System.out.println("Attempt " + attempt + ": Service is back.");
                return Flux.just("Book A", "Book B");
            }
        });

        bookService
                .retryWhen(
                        Retry.backoff(3, Duration.ofMillis(500))
                                .onRetryExhaustedThrow((retryBackoffSpec, retrySignal) -> retrySignal.failure())
                )
                .subscribe(
                        book -> System.out.println("Received: " + book),
                        error -> System.out.println("Final error: " + error.getMessage()),
                        () -> System.out.println("Stream completed")
                );

        //* Give time for retries (backoff delays)
        Thread.sleep(30000);
    }
}
