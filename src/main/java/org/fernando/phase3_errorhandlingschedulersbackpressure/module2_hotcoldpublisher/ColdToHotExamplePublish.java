package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class ColdToHotExamplePublish {
    public static void main(String[] args) throws InterruptedException {
        //*  Counter to prove single vs multiple executions
        var executionCounter = new AtomicInteger(0);

        //* Step 1: Create a COLD Flux
        Flux<String> coldFlux = Flux.interval(Duration.ofMillis(500))
                .take(5)
                .map(tick -> {
                    int execution = executionCounter.incrementAndGet();
                    String data = "Data-" + tick + "(Execution #" + execution + ")";
                    System.out.println("Cold: Generated " + data);
                    return data;
                });

        System.out.println("--- Cold Behavior: Each subscriber = New execution ---");
        coldFlux.subscribe(data -> System.out.println(" Sub1 received " + data));
        Thread.sleep(100);
        coldFlux.subscribe(data -> System.out.println(" Sub2 received " + data));

        Thread.sleep(3000); //* Wait for cold subscription to complete
        System.out.println("Cold executions finished. Counter = " + executionCounter.get() + "\n");

        //* Reset counter for hot demonstration
        executionCounter.set(0);

        //* Step 2: Convert COLD to HOT using publish.connect()
        System.out.println("--- Converting to HOT Publisher ---");
        ConnectableFlux<String> hotFlux = Flux.interval(Duration.ofMillis(500))
                .take(5)
                .map(tick -> {
                    int execution = executionCounter.incrementAndGet();
                    String data = "Data-" + tick + "(Execution #" + execution + ")";
                    System.out.println("HOT: Generated " + data);
                    return data;
                })
                .publish(); //* Convert to ConnectableFlux - HOT but not started

        //* Add subs BEFORE connecting
        System.out.println("Adding subs before starting");
        hotFlux.subscribe(data -> System.out.println(" HotSub1 received: " + data));
        hotFlux.subscribe(data -> System.out.println(" HotSub2 received: " + data));
        Thread.sleep(1000);

        //* Step 3: Start the HOT publisher
        System.out.println("Calling connect() - Starting single shared execution");
        hotFlux.connect();

        //* Add a late subs
        Thread.sleep(1500);
        System.out.println("Adding late subs");
        hotFlux.subscribe(data -> System.out.println("LateSub received: " + data + "(missed earlier data"));
        Thread.sleep(2000);

        System.out.println("\n Final results");
        System.out.println("COLD: subs = 10 total executions (5+5)");
        System.out.println("HOT: 3 subs = 5 total executions (shared single stream)");
        System.out.println("HOT counter = " + executionCounter.get());


    }
}
