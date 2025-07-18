package org.fernando.phase1_fundamentals.module5_reactiveerror;

import reactor.core.publisher.Flux;

/*
 * What’s Happening?
 * mainBookService fails immediately by emitting an error.
 * onErrorResume catches the error, logs it, and switches to fallbackBooks.
 * The subscriber receives books from the fallback and sees a clean stream completion
 */
public class OnErrorResumeExample {
    public static void main(String[] args) {
        // Simulate a failing main source (e.g. remote API)
        Flux<String> mainBookService = Flux.<String>error(new RuntimeException("Remote service unavailable"));

        // Fallback data
        Flux<String> fallbackBooks = Flux.just("Cached Book 1", "Cached Book 2", "Cached Book 3");

        // Use onErrorResume to switch to fallback stream if an error occurs
        Flux<String> booksStream = mainBookService
                .onErrorResume(error -> {
                    System.out.println("Error occurred : " + error.getMessage());
                    System.out.println("Switching to fallback book list...");
                    return fallbackBooks;
                });
        // Subscribe and print the result
        booksStream.subscribe(
                book -> System.out.println("Received : " + book),
                error -> System.err.println("Final error: " + error.getMessage()),
                () -> System.out.println("Book stream completed")
        );

    }
}
