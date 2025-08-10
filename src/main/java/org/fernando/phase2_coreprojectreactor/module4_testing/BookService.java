package org.fernando.phase2_coreprojectreactor.module4_testing;

import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

public class BookService {
    private static final Map<String, String> bookDB = Map.of(
            "1", "Clean Code",
            "2", "Reactive Spring",
            "3", "Domain-Driven Design"
    );

    public static Mono<String> getBookById(String id) {
        return Mono.defer(() -> {
            if (bookDB.containsKey(id)) {
                return Mono.just(bookDB.get(id))
                        .delayElement(Duration.ofMillis(200)); //* Simulate async call
            } else {
                return Mono.error(new RuntimeException("Book not found: " + id));
            }
        });
    }

    public static Mono<String> fallBackBook(String id) {
        return Mono.just("Unknown Book (Fallback for ID: " + id + ")");
    }
}
