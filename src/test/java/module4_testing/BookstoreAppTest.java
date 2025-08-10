package module4_testing;

import org.fernando.phase2_coreprojectreactor.module4_testing.BookService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/*
 * ---Purpose of the Test---
 * “We’re testing a reactive service that looks up book titles by ID.
 * If the ID is valid, it returns the book name asynchronously.
 * If the ID is missing, it gracefully falls back to a default message —
 * all without throwing exceptions.”
 *
 * ---Why StepVerifier---
 * “Since this is a non-blocking, asynchronous flow, traditional assertions
 * won't work. We use StepVerifier to declaratively check the emissions —
 * in order — and ensure the fallback behavior works.”
 *
 * ---Importance of concatMap---
 * use concatMap to preserve the order of book IDs. flatMap would cause the
 * results to come back out of order, especially since we're simulating delays. *
 * */

class BookstoreAppTest {

    @Test
    void testBookLookupWithFallback() {
        Flux<String> bookIds = Flux.just("1", "404", "2");
        Flux<String> books = bookIds
                .concatMap(id ->
                        BookService.getBookById(id)
                                .onErrorResume(e -> BookService.fallBackBook(id)));

        StepVerifier.create(books)
                .expectNext("Clean Code")
                .expectNext("Unknown Book (Fallback for ID: 404)")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }

}
