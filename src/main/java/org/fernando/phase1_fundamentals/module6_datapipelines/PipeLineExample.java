package org.fernando.phase1_fundamentals.module6_datapipelines;

import reactor.core.publisher.Flux;

public class PipeLineExample {
    public static void main(String[] args) {
        Flux<String> books = Flux.just("Java 101", "Spring in Action", "Java Programming");

        books
                .filter(title -> title.contains("Java"))
                .map(String::toUpperCase)
                .subscribe(System.out::println);
    }
}
