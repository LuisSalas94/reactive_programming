package org.fernando.phase1_fundamentals.module1_intro;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactiveBookProcessor {
    public static Flux<Book> getBooksStream() {
        return Flux.just(
                new Book("Reactive Design Patterns", "Tech"),
                new Book("The Hobbit", "Fantasy"),
                new Book("Clean Code", "Tech"),
                new Book("Lord of the Rings", "Fantasy")
        ).subscribeOn(Schedulers.boundedElastic()); // Simulate async data fetching
    }
}
