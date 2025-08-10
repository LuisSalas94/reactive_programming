package org.fernando.phase2_coreprojectreactor.module4_testing;

import reactor.core.publisher.Flux;

public class BookstoreApp {
    public static void main(String[] args) {
        Flux<String> bookIds = Flux.just("1", "2", "404", "3", "500");

        Flux<String> books = bookIds
                .flatMap(id ->
                        BookService.getBookById(id)
                                .onErrorResume(e -> {
                                    System.out.println("Error fetching ID " + id + ":" + e.getMessage());
                                    return BookService.fallBackBook(id);
                                }));
        books
                .doOnNext(book -> System.out.println("Received: " + book))
                .blockLast(); //* Wait until all books are processed
    }
}
