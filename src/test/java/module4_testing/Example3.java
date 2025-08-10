package module4_testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.concurrent.atomic.AtomicInteger;

class Example3 {

    /*
     * Demonstrates fallback behavior using onErrorResume.
     * When the source Mono fails, a fallback value is emitted instead,
     * preserving a successful completion path.
     */
    @Test
    void shouldFallbackToDefaultValueOnError() {
        Mono<Object> fallBackMono = Mono.error(new IllegalArgumentException("Invalid book ID"))
                .onErrorResume(ex -> Mono.just("Default Book"));

        StepVerifier.create(fallBackMono)
                .expectNext("Default Book")
                .expectComplete()
                .verify();
    }

    /*
     * Demonstrates retry logic.
     * The source emits an error twice before succeeding on the third try.
     */
    @Test
    void shouldRetryOnErrorAndEventuallySucceed() {
        AtomicInteger attempt = new AtomicInteger(0);
        Mono<String> retryMono = Mono.defer(() -> {
            if (attempt.incrementAndGet() < 3) {
                return Mono.error(new RuntimeException("Temporary error"));
            }
            return Mono.just("Success after retry");
        }).retry(2);

        StepVerifier.create(retryMono)
                .expectNext("Success after retry")
                .expectComplete()
                .verify();
    }

}
