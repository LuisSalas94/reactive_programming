package org.fernando.phase2_coreprojectreactor.module1_monoflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmptyErrorExample {

    //* Simulate user lookup
    public static Mono<String> findUserById(String userId) {
        if (userId.equals("unknown-id")) {
            return Mono.empty(); // No user found
        } else if (userId.equals("db-fail")) {
            return Mono.error(new RuntimeException("Database not reachable"));
        } else {
            return Mono.just("User: Gozde");
        }
    }

    //* Simulate getting books
    public static Flux<String> getBookInStock(boolean simulateError) {
        if (simulateError) {
            return Flux.error(new RuntimeException("Connection timeout"));
        }

        boolean hasBooks = false;

        if (hasBooks) {
            return Flux.just("Book A", "Book B", "Book c");
        } else {
            return Flux.empty();
        }
    }

    public static void main(String[] args) {
        //* Mono example: No user found
        Mono<String> userLookUp = findUserById("unknown-id");
        userLookUp.subscribe(
                result -> System.out.println("Found user: " + result),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("No user found.\n"));

        //* Flux example: No books in stock
        Flux<String> booksInStock = getBookInStock(false);
        booksInStock.subscribe(
                book -> System.out.println("Book: " + book),
                error -> System.out.println("Error loading books: " + error.getMessage()),
                () -> System.out.println("No books available.\n"));

        //* Mono error example: database down
        Mono<String> userWithError = findUserById("db-fail");
        userWithError.subscribe(
                user -> System.out.println("User: " + user),
                error -> System.out.println("User lookup failed: " + error.getMessage()),
                () -> System.out.println("Done"));

        //* Flux error example: connection failure
        Flux<String> booksWithError = getBookInStock(true); // true = simulate error
        booksWithError.subscribe(
                book -> System.out.println("Book: " + book),
                error -> System.out.println("Failed to load books: " + error.getMessage()),
                () -> System.out.println("Books load complete"));


    }
}
