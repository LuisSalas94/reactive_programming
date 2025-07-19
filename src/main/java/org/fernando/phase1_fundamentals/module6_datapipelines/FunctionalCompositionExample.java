package org.fernando.phase1_fundamentals.module6_datapipelines;


import reactor.core.publisher.Flux;

public class FunctionalCompositionExample {
    public static void main(String[] args) {
        Flux<String> bookTitles = Flux.just(
                "  spring boot in action  ",
                "REACTIVE programming with java",
                "   clean code  ",
                "java concurrency in practice"
        );

        //* Functional Steps
        Flux<String> processedTitles = bookTitles
                .map(String::trim) // remove extra spaces
                .map(String::toLowerCase) // normalize case
                .filter(title -> title.contains("java")) // only books about Java
                .map(title -> "Recommended: " + title); // format nicely

        processedTitles
                .subscribe(System.out::println);

    }
}
