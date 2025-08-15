package org.fernando.phase3_errorhandlingschedulersbackpressure.module1_errorhandling;

import reactor.core.publisher.Flux;
/*
* What happens here:
1. onNext(T value)
First Flux emits "Clean Code", "Reactive Spring", and "DDD" as onNext signals.
Each item is printed with the [onNext] prefix.

2. onComplete()
In the first stream, after the last onNext signal, Reactor sends onComplete.
The message "All books emitted." is printed.

3. onError(Throwable error)
In the second stream, after emitting three books, Reactor sends onError because of Flux.error(...).
No onComplete happens after that.
The error message "Database connection lost" is printed.
*
* */


public class SignalsExample {
    public static void main(String[] args) {

        //* Example 1: Stream that completes successfully
//        Flux<String> bookTitles = Flux.just("Clean Code", "Reactive Spring", "DDD")
//                .doOnNext(title -> System.out.println("[onNext] " + title))
//                .doOnComplete(() -> System.out.println("[onComplete] All books emitted."))
//                .doOnError(error -> System.out.println("[onError] " + error.getMessage()));
//
//        System.out.println("=== Successful Stream ===");
//        bookTitles.subscribe();

        //* Example 2: Stream that fails with an error
        Flux<String> faultyStream = Flux.just("Clean Code", "Reactive Spring", "DDD")
                .concatWith(Flux.error(new RuntimeException("Database connection lost")))
                .doOnNext(title -> System.out.println("[onNext] " + title))
                .doOnComplete(() -> System.out.println("[onComplete] This will NOT be printed."))
                .doOnError(error -> System.out.println("[onError] " + error.getMessage()));

        System.out.println("=== Failing Stream ===");
        faultyStream.subscribe();
    }
}
