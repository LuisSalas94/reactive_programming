package org.fernando.phase2_coreprojectreactor.module2_operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class TerminalOperatorsExample {
    public static void main(String[] args) {
        Flux<String> books = Flux.just(
                "Domain-Driven Design",
                "Effective Java",
                "Programming Pearls"
        ).doOnNext(title -> System.out.println("Preparing: " + title));

        //* Terminal operator 1: subscribe()
//        books.subscribe(
//                title -> System.out.println("Subscribed received: " + title + "\n"),
//                error -> System.out.println("Error: " + error),
//                () -> System.out.println("Stream completed")
//        );

        //* Terminal operator 2: collectList() + block()
        Mono<List<String>> bookListMono = Flux.just("Clean Architecture", "Refactoring")
                .doOnNext(title -> System.out.println("Collecting: " + title))
                .collectList(); //* Collects all emitted items into a List
        List<String> bookList = bookListMono.block(); //* Triggers the flow and blocks for the result
        System.out.println("\nCollected book list: " + bookList);

    }
}
