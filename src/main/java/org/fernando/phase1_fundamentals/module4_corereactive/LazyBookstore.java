package org.fernando.phase1_fundamentals.module4_corereactive;

import reactor.core.publisher.Flux;

public class LazyBookstore {
    public static void main(String[] args) {

        Flux<String> books = Flux.just("Clean Code", "Effective Java", "Design Patterns in Java")
                .doOnNext(book -> System.out.println("Fetching book: " + book));

        System.out.println("Book pipeline created, but nothing is fetched yet.");

        books.subscribe(book -> System.out.println("Customer received: " + book));

    }

}
