package org.fernando.phase2_coreprojectreactor.module2_operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class IntermediateOperatorsExample {
    //* Simulates an asynchronous operation
    //* like fetching metadata from a remote services
    public static Mono<String> simulateRemoteLookUp(String bookTitle) {
        return Mono.fromSupplier(() -> {
            System.out.println("Looking up metadata for: " + bookTitle);
            return "[META" + bookTitle + "]";
        });
    }

    public static void main(String[] args) {
        Flux<String> bookTitles = Flux.just(
                "Clean Code",
                "Reactive Programming in Java",
                "The Art of Computer Programming",
                "Intro to Cooking",
                "Refactoring"
        );

        Flux<String> processedBooks = bookTitles
                .filter(title -> title.toLowerCase().contains("programming"))
                .map(title -> title.toUpperCase())
                .flatMap(title -> simulateRemoteLookUp(title));

        System.out.println("Pipeline defined, nothing executed yet.");

        processedBooks.subscribe(
                result -> System.out.println("Subscriber received: " + result + "\n"),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Stream completed")
        );

    }
}
