package org.fernando.phase1_fundamentals.module5_reactiveerror;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * What’s Happening?
 * Flux.defer() delays the creation of the Flux until each subscription attempt.
 * The first 2 attempts fail, but retry(2) automatically retries.
 * On the 3rd attempt, the service succeeds.
 * The books are emitted and the stream completes successfully.
 * If all 3 attempts had failed, the error would have gone to the subscriber.
 */

public class RetryExample {
    public static void main(String[] args) {
        //* Simulate a counter to fail the first two attempts
        AtomicInteger attemptCounter = new AtomicInteger(0);

        Flux<String> bookService = Flux.defer(() -> {
            int attempt = attemptCounter.incrementAndGet();
            if (attempt < 3) {
                System.out.println("Attempt: " + attempt + ": Service is down");
                return Flux.error(new RuntimeException("Temporary service failure"));
            } else {
                System.out.println("Attempt " + attempt + ": Service recovered");
                return Flux.just("Book A", "Book B");
            }
        });

        //* Retry up to 2 times before failing
        bookService
                .retry(2)
                .subscribe(
                        book -> System.out.println("Received: " + book),
                        error -> System.out.println("Final error: " + error.getMessage()),
                        () -> System.out.println("Stream completed")
                );
    }
}
