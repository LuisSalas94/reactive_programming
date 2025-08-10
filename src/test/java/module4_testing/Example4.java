package module4_testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


class Example4 {

    /*
     * Demonstrates early cancellation.
     * Useful when consumers may unsubscribe before full emission.
     */
    @Test
    void shouldCancelSubscriptionEarly() {
        StepVerifier.create(Flux.range(1, 10))
                .expectNext(1, 2)
                .thenCancel()
                .verify();
    }

    /*
     * Asserts that an empty Mono completes without emissions.
     * Important for verifying no-op pipelines.
     */
    @Test
    void shouldCompleteWithoutEmission() {
        StepVerifier.create(Mono.empty())
                .expectComplete()
                .verify();
    }

}
