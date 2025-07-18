package org.fernando.phase1_fundamentals.module5_reactiveerror;

import reactor.core.publisher.Flux;

/*
 * What’s Happening?
 * bookService throws an error.
 * onErrorReturn catches the error and emits a single fallback value ("Default Book: Please Try Again Later").
 * The stream completes normally after that.
 * No error is passed to the subscriber.
 * */

public class OnErrorReturnExample {
    public static void main(String[] args) {
        //* Simulate a failing main source (e.g. due to timeout)
        Flux<String> bookService = Flux.<String>error(new RuntimeException("Failed to load books"));

        //* Use onErrorReturn to emit a single fallback book title on error
        Flux<String> safeBookStream = bookService.onErrorReturn("Default Book: Please Try Again Later");

        //* Subscribe and print result
        safeBookStream.subscribe(
                book -> System.out.println("Received: " + book),
                error -> System.err.println("Stream failed with error: " + error.getMessage()),
                () -> System.out.println("Stream completed")
        );


    }
}
