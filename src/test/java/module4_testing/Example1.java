package module4_testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/*
 * These tests illustrate the basics of what you're actually testing
 * in a reactive pipeline: emissions, ordering, completion, and error handling.
 * */


class Example1 {

    /*
     * StepVerifier acts like a virtual subscriber and allows us to assert:
     * The exact order of values (expectNext)
     * That the stream completes normally (expectComplete)
     * This is a fundamental pattern in testing reactive pipelines where ordering,
     * completeness, and determinism matter.
     */
    @Test
    void shouldEmitBookTitlesInOrder() {
        Flux<String> bookTitles = Flux.just(
                "Effective Java",
                "Reactive Spring",
                "Domain-Driven Design"
        );

        StepVerifier.create(bookTitles)
                .expectNext("Effective Java")
                .expectNext("Reactive Spring")
                .expectNext("Domain-Driven Design")
                .expectComplete()
                .verify();
    }

    /*
     * Using expectErrorMessage, we assert:
     * That the stream ends in error (not with data or onComplete)
     * That the error message matches exactly
     * This pattern is common when simulating or validating fail-fast behavior
     * in services or operator chains that may short-circuit based on business rules
     */
    @Test
    void shouldEmitRuntimeException() {
        Mono<String> errorMono = Mono.error(new RuntimeException("Book not found"));
        StepVerifier.create(errorMono)
                .expectErrorMessage("Book not found")
                .verify();
    }
}
