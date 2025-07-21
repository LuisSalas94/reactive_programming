package org.fernando.phase2_coreprojectreactor.module1_monoflux;

import reactor.core.publisher.Flux;

public class FluxLifecycleExample {

    //* Emits multiple book titles and completes
    public static Flux<String> fetchAllBooks() {
        return Flux.just("Clean Code", "Effective Java", "Reactive Spring");
    }

    //* Emits multiple title and completes
    public static Flux<String> fetchEmptyBookList() {
        return Flux.empty();
    }

    //* Emits a few items, them fails
    public static Flux<String> fetchBooksWithError() {
        return Flux.just("Domain-Driven Design", "The Pragmatic Programmer")
                .concatWith(Flux.error(new RuntimeException("Database connection failed")));
    }

    public static void main(String[] args) {
        //* Example 1
        System.out.println("Example 1: Books Found");
        fetchAllBooks()
                .doOnSubscribe(sub -> System.out.println("Subscribed to book list"))
                .doOnNext(book -> System.out.println("doOnNext: " + book))
                .doOnComplete(() -> System.out.println("doOnComplete: All books sent"))
                .doOnError(error -> System.out.println("doOnError: " + error.getMessage()))
                .subscribe();

        //* Example 2
        System.out.println("\nExample 2: No Books Found");
        fetchEmptyBookList()
                .doOnSubscribe(sub -> System.out.println("Subscribed to empty book list"))
                .doOnNext(book -> System.out.println("doOnNext: " + book))
                .doOnComplete(() -> System.out.println("doOnComplete: No Books to send"))
                .subscribe();

        //* Example 3
        System.out.println("\nExample 3: Error While Fetching");
        fetchBooksWithError()
                .doOnSubscribe(sub -> System.out.println("Subscribed to empty book list"))
                .doOnNext(book -> System.out.println("doOnNext: " + book))
                .doOnComplete(() -> System.out.println("doOnComplete: Done"))
                .doOnError(error -> System.err.println("doOnError: " + error.getMessage()))
                .subscribe();

    }
}
