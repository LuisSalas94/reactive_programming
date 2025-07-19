package org.fernando.phase1_fundamentals.module6_datapipelines;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
 * Benefits
 * Immutability: Titles are transformed into new values (trim(), toUpperCase()), not modified in-place.
 * Side-effect isolation: All side effects are clearly marked using doOnNext() and flatMap().
 * Non-blocking: The entire chain remains reactive and asynchronous.
 * Readable & Debuggable: Pure logic is separated from effects, which makes debugging easier.
 * */

public class ImmutabilitySideEffectExample {
    private static Mono<String> saveToDatabase(String title) {
        return Mono.just("Saved[" + title + "]");
    }

    public static void main(String[] args) {
        Flux<String> rawTitles = Flux.just(" Clean Code ", "Effective Java", "Reactive Programming in Java");

        rawTitles
                //* Transform
                .map(title -> title.trim())
                .map(title -> title.toUpperCase())
                //* Side-Effect logging
                .doOnNext(title -> System.out.println("Transformed title: " + title))
                //* Simulate saving
                .flatMap(ImmutabilitySideEffectExample::saveToDatabase)
                //* More logging
                .doOnNext(saved -> System.out.println("Saved to DB: " + saved))
                //* Print final result
                .subscribe(result -> System.out.println("Final Output: " + result + "\n"));
    }
}
