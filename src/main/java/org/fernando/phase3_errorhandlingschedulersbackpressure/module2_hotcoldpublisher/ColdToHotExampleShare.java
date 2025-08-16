package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class ColdToHotExampleShare {
    private static void demonstrateColdBehavior() throws InterruptedException {
        var coldCounter = new AtomicInteger(0);

        // Cold stream - each subscriber gets own execution
        Flux<String> coldStream = createStream(coldCounter, "COLD");

        coldStream.subscribe(data -> System.out.println("Sub1: " + data));
        Thread.sleep(800);
        coldStream.subscribe(data -> System.out.println("Sub2: " + data));
        Thread.sleep(1500);

        System.out.println("Cold executions: " + coldCounter.get());
    }

    private static void demonstrateHotBehavior() throws InterruptedException {
        var hotCounter = new AtomicInteger(0);

        // Hot stream - shared execution
        Flux<String> hotStream = createStream(hotCounter, "HOT").share();

        hotStream.subscribe(data -> System.out.println("Sub1: " + data));
        Thread.sleep(1000); // Let Sub1 get some data first
        hotStream.subscribe(data -> System.out.println("Sub2: " + data + " (joined late!)"));
        Thread.sleep(1500);

        System.out.println("Hot executions: " + hotCounter.get());
    }

    private static Flux<String> createStream(AtomicInteger counter, String type) {
        return Flux.range(1, 3)
                .delayElements(Duration.ofMillis(400))
                .doOnSubscribe(s -> System.out.println(type + " stream started #" + counter.incrementAndGet()))
                .map(i -> "Data-" + i);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Cold Behavior ===");
        demonstrateColdBehavior();

        System.out.println("=== Hot Behavior ===");
        demonstrateHotBehavior();

    }
}

