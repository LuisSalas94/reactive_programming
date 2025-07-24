package org.fernando.phase2_coreprojectreactor.module3_dynamicdatastreams;

import reactor.core.publisher.Flux;
/*
 * What This Demonstrates:
 * Emits one book title per request using Flux.generate().
 * Keeps track of the current index as state.
 * Gracefully finishes the stream when all books are emitted.
 *
 * Index (State)
 * It represents the state of the generator.
 * In our example, it's used to track which book to emit next from the array.
 * It starts at 0 (set by () -> 0) and is updated every time with return index + 1.
 *
 *  Sink (FluxSink)
 * It's the object that sends data (sink.next()), signals completion
 * (sink.complete()), or signals error (sink.error()).
 * This is how you emit values into the Flux stream.
 * */

public class FluxGenerateExample {
    public static void main(String[] args) {
        String[] books = {
                "Clean Code",
                "Effective Java",
                "Reactive Spring",
                "Java Concurrency in Practice"
        };

        Flux<String> bookFlux = Flux.generate(
                () -> 0, //* Initial state: start from index 0
                (index, sink) -> {
                    if (index < books.length) {
                        sink.next(books[index]); //* Emit one book at a time
                    } else {
                        sink.complete(); //* End the stream
                    }
                    return index + 1; //* Update state (index) for next iteration
                });

        bookFlux.subscribe(
                title -> System.out.println("Received:" + title),
                error -> System.out.println("Error: " + error.getMessage()),
                () -> System.out.println("Stream Completed")
        );

    }
}
