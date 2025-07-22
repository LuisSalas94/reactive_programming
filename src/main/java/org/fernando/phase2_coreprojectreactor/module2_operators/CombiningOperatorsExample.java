package org.fernando.phase2_coreprojectreactor.module2_operators;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombiningOperatorsExample {
    //* 1. zip(): Combine book titles with prices
    private static void zipExample() {
        Flux<String> titles = Flux.just("Reactive Java", "Clean Code", "Spring in Action");
        Flux<Double> prices = Flux.just(39.99, 29.99, 49.99);

        Flux<String> combined = Flux.zip(titles, prices)
                .map(tuple -> tuple.getT1() + " - $" + tuple.getT2());
        combined.subscribe(System.out::println);
    }

    //* 2. combineLatest(): Combine latest stock and discount updates
    private static void combineLatestExample() throws InterruptedException {
        Flux<Integer> stock = Flux.just(100, 80, 50)
                .delayElements(Duration.ofMillis(400));

        Flux<Integer> discount = Flux.just(10, 20, 30)
                .delayElements(Duration.ofMillis(600));

        Flux<String> combined = Flux.combineLatest(
                stock,
                discount,
                (s, d) -> "Stock: " + s + " units | Discount: " + d + "%"
        );

        combined.subscribe(System.out::println);

    }

    //* 3. merge(): Merge reviews and alerts as they arrive
    public static void mergeExample() {
        Flux<String> reviews = Flux.just("Great Book", "Loved it")
                .delayElements(Duration.ofMillis(300));

        Flux<String> alerts = Flux.just("Low Stock", "Price Drop")
                .delayElements(Duration.ofMillis(500));

        Flux<String> merged = Flux.merge(reviews, alerts);

        merged.subscribe(msg -> System.out.println("Msg: " + msg));
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("---zip(): Combine Book Title and Price---");
        zipExample();

        Thread.sleep(2000);

        System.out.println("\n---combineLatest() - Live Stock & Discount info---");
        combineLatestExample();

        Thread.sleep(3000);

        System.out.println("\nmerge(): Merging Book Review and Alerts\n");
        mergeExample();

        Thread.sleep(5000);

    }
}
