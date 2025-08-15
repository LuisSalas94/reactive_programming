package org.fernando.phase3_errorhandlingschedulersbackpressure.module1_errorhandling;

/*
* How it works
Mono.error(...) creates a stream that immediately sends an onError signal.
No onNext values are emitted.
onComplete() is never called after onError.
The subscriber receives only the error and the stream stops.
*
* */

import reactor.core.publisher.Mono;

public class TerminalErrorExample {
    public static void main(String[] args) {
        Mono<String> errorMono = Mono.<String>error(new RuntimeException("Something went wrong"))
                .doOnSubscribe(sub -> System.out.println("[Subscribed]"))
                .doOnNext(value -> System.out.println("[onNext] " + value)) //* Will never be called
                .doOnError(error -> System.err.println("[onError] " + error.getMessage()))
                .doOnSuccess(value -> System.out.println("[onSuccess] This will NOT be printed."));

        //* Subscribe to the Mono
        errorMono.subscribe(
                value -> System.out.println("Subscriber received: " + value),
                error -> System.out.println("Subscriber error: " + error.getMessage()),
                () -> System.out.println("Subscriber complete") //* Will not be called
        );


    }
}
