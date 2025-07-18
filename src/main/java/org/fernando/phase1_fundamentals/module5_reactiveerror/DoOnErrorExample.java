package org.fernando.phase1_fundamentals.module5_reactiveerror;

import reactor.core.publisher.Flux;

/*
 * What’s Happening?
 * The stream throws an error (RuntimeException).
 * doOnError logs the error as a side effect, but doesn’t handle or recover from it.
 * The error is still sent to the subscriber.
 * The stream does not complete successfully — it terminates with the error.
 */

public class DoOnErrorExample {
    public static void main(String[] args) {
        //* Simulate a book service that fails
        Flux<String> bookService = Flux.<String>error(new RuntimeException("Database timeout"));

        //* Use doOnError to log the error before it reaches the subscriber
        Flux<String> monitoredBookService = bookService
                .doOnError(error -> System.out.println("[LOG] Error occurred: " + error.getMessage()));

        //* Subscribe to the stream
        monitoredBookService.subscribe(
                book -> System.out.println("Received: " + book),
                error -> System.out.println("Subscriber received error: " + error.getMessage()),
                () -> System.out.println("Stream completed.")
        );

    }
}
