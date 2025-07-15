package org.fernando.phase1_fundamentals.module4_corereactive;

import reactor.core.publisher.Flux;

public class ColdPublisherBookstore {
    public static void main(String[] args) {
        Flux<String> bookCatalog = Flux.just("Clean Code", "Effective Java", "Design Patterns in Java")
                .doOnSubscribe(sub -> System.out.println("Starting new book delivery"))
                .doOnNext(book -> System.out.println("Preparing book: " + book));

        // First Customer
        System.out.println("\nCustomer 1");
        bookCatalog.subscribe(book -> System.out.println("Customer 1 gets: " + book));

        // Second Customer subscribes later - gets the full list again
        System.out.println("\nCustomer 2");
        bookCatalog.subscribe(book -> System.out.println("Customer 2 gets: " + book));
    }
}
