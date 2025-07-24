package org.fernando.phase2_coreprojectreactor.module3_dynamicdatastreams;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/*
 *  What This Demonstrates:
 * Uses Flux.create() to manually emit items.
 * A new thread is used to simulate async behavior (like a book feed).
 * Emits one book every 500 milliseconds.
 * Uses emitter.next(...), emitter.complete(), and emitter.error(...).
 * */


public class FluxCreateAsynchronousExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> books = Arrays.asList("Clean Code", "Effective Java", "Spring Reactive");
        Flux<String> bookFlux = Flux.create(emitter -> {
            //* Emit books asynchronously using a separate thread
            new Thread(() -> {
                try {
                    for (String book : books) {
                        emitter.next(book); //* Emit one book
                        Thread.sleep(500); //* Simulate delay (async)
                    }
                    emitter.complete(); //* Signal completion
                } catch (Exception e) {
                    emitter.error(e); //* Signal error if something goes wrong
                }
            }).start();
        });

        bookFlux
                .doOnNext(book -> System.out.println("Received: " + book))
                .doOnComplete(() -> System.out.println("All books received"))
                .subscribe();
        //* Keep main thread alive to see async output
        Thread.sleep(3000);
    }
}
