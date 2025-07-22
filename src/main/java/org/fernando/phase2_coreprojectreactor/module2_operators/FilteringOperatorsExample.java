package org.fernando.phase2_coreprojectreactor.module2_operators;

import reactor.core.publisher.Flux;

public class FilteringOperatorsExample {
    static class Book {
        String title;
        int stock;

        public Book(String title, int stock) {
            this.title = title;
            this.stock = stock;
        }
    }

    public static void main(String[] args) {
        //* Sample book titles their stock counts and length
        Flux<Book> bookFlux = Flux.just(
                new Book("Clean Code", 12),
                new Book("Reactive Spring", 0),
                new Book("DDD", 5),
                new Book("Effective Java", 2)
        );

        bookFlux
                .filter(book -> book.stock > 0) //* only books that are in stock
                .filter(book -> book.title.length() >= 5) //* title must be at least 5 characters
                .doOnNext(book -> System.out.println("Available book: " + book.title))
                .subscribe();
    }
}
