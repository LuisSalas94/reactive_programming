package org.fernando.phase2_coreprojectreactor.module1_monoflux;

import reactor.core.publisher.Mono;

public class MonoLifecycleExample {
    public static Mono<String> findBookByTitle(String title) {
        if ("Effective Java".equalsIgnoreCase(title)) {
            return Mono.just("Effective Java by Joshua Bloch");
        } else {
            return Mono.empty();
        }
    }

    public static void main(String[] args) {
        //* Simulated book search
        String titleToFind = "Effective Java";

        //* Example 1: Book found
        findBookByTitle(titleToFind)
                .doOnSubscribe(sub -> System.out.println("Subscribed to book search..."))
                .doOnNext(book -> System.out.println("doOnNext: Found Book: " + book))
                .doOnSuccess(book -> System.out.println("doOnSuccess: Search completed"))
                .doOnError(error -> System.err.println("onError: " + error.getMessage()))
                .subscribe();

        //* Example 2: Book not found
        findBookByTitle("Unknown Book")
                .doOnSubscribe(sub -> System.out.println("\nSubscribed to second search"))
                .doOnNext(book -> System.out.println("doOnNext: Found Book - " + book))
                .doOnSuccess(book -> {
                    if (book == null) {
                        System.out.println("onComplete: No Book Found");
                    }
                })
                .subscribe();


    }
}
