package module4_testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

/*
 * Here we demonstrate time-sensitive behavior and show how StepVerifier
 *  uses virtual time to simulate complex pipelines without slowing down the test suite.
 * */

class Example2 {
    /*
     * Demonstrates how to test time-sensitive operators
     * (e.g., interval, delay)
     * using VirtualTimeScheduler.
     * This avoids real-time waits, enabling fast and deterministic tests
     * for reactive time flows.
     */
    @Test
    void shouldEmitThreeItemsOverThreeSecondsUsingVirtualTime() {
        VirtualTimeScheduler.getOrSet();
        StepVerifier.withVirtualTime(() ->
                        Flux.interval(Duration.ofSeconds(1)).take(3) //* emits 0, 1, 2
                )
                .thenAwait(Duration.ofSeconds(3))//* fast-forward 3 seconds
                .expectNext(0L, 1L, 2L)
                .expectComplete()
                .verify();
    }

    /*
     * Demonstrates delay-based transformation and fast-forwarding virtual time.
     * Useful when operators like delayElement are involved.
     */
    @Test
    void shouldDelayElementsWithoutWaitingInRealTime() {
        VirtualTimeScheduler.getOrSet();

        StepVerifier.withVirtualTime(() ->
                        Flux.just("A", "B")
                                .delayElements(Duration.ofSeconds(2))
                )
                .thenAwait(Duration.ofSeconds(4))
                .expectNext("A", "B")
                .expectComplete()
                .verify();
    }


}
