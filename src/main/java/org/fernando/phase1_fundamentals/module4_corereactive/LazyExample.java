package org.fernando.phase1_fundamentals.module4_corereactive;

import reactor.core.publisher.Flux;

public class LazyExample {
    public static void main(String[] args) {
        Flux<String> flux = Flux.<String>create(emitter -> {
            System.out.println("Publisher logic running");
            emitter.next("Hello");
            emitter.next("Reactive");
            emitter.next("World");
            emitter.complete();
        });
        flux.subscribe(item -> System.out.println("Received: " + item));
    }
}

