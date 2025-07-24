package org.fernando.phase2_coreprojectreactor.module3_dynamicdatastreams;

import reactor.core.publisher.Flux;
/*
 * --- What This Demonstrates ---
 * You manually emit each book title using emitter.next(...).
 * The stream ends with emitter.complete().
 * Flux.create() is useful when values are not known up front or when
 * emission depends on logic or callbacks.
 * */

public class FluxCreateSynchronousExample {
    public static void main(String[] args) {
        Flux<String> bookFlux = Flux.create(emitter -> {
            //* Emitting book titles synchronously
            emitter.next("Clean Code");
            emitter.next("Effective Java");
            emitter.next("Domain-Driven Design");
            emitter.next("Reactive Spring");
            //* Complete the stream
            emitter.complete();
        });
        //* Subscribing to the flux
        bookFlux.subscribe(
                book -> System.out.println("Received: " + book),
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Stream completed")
        );
    }
}
