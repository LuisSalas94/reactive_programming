package org.fernando.phase2_coreprojectreactor.module1_monoflux;

import reactor.core.publisher.Flux;

public class LazyEvaluationExample {
    public static void main(String[] args) {
        Flux<String> delayedFlux = Flux.just("Book A", "Book B", "Book c")
                .doOnNext(title -> System.out.println("Processing: " + title));

        System.out.println("Pipeline defined, but not executed");
        delayedFlux.subscribe(title -> System.out.println("Received: " + title + "\n"));

    }
}
