package org.fernando.phase2_coreprojectreactor.module2_operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TransformationOperatorsExample {
    private static Mono<String> getBookPrice(String title) {
        return Mono.just("Price of \"" + title + "\" is $" + (title.length() * 2))
                .doOnSubscribe(sub -> System.out.println("Fetching price for " + title));
    }

    public static void main(String[] args) {
        //* Original book titles
        Flux<String> books = Flux.just("Clean Code", "Reactive Spring", "Refactoring");

        //* Using map(): transform book titles to uppercase
        books
                .map(title -> title.toUpperCase()) //* simple synchronous transformation
                .doOnNext(title -> System.out.println("Mapped (uppercase): " + title))
                .subscribe();

        System.out.println("\n---\n");

        //* Using flatmap(): simulate async lookup of book prices
        Flux<String> bookTitles = Flux.just("Domain-Driven Design", "Effective Java");
        bookTitles
                .flatMap(title -> getBookPrice(title))
                .doOnNext(priceInfo -> System.out.println("Retrieved: " + priceInfo + "\n"))
                .subscribe();
    }
}
