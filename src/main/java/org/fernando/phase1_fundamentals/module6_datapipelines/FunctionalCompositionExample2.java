package org.fernando.phase1_fundamentals.module6_datapipelines;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public class FunctionalCompositionExample2 {
    //* Simulated book price database
    static Map<String, Double> priceDatabase = Map.of(
            "Spring in Action", 45.0,
            "Reactive Java", 60.0,
            "Clean Code", 50.0,
            "Effective Java", 70.0
    );

    //* Simulate async DB/APi call to get price
    static Mono<Double> getPrice(String title) {
        Double price = priceDatabase.get(title);
        return price != null ? Mono.just(price) : Mono.empty();
    }

    //* Apply a discount
    static double applyDiscount(double price, double discountRate) {
        return price - (price * discountRate);
    }

    //* Format for display
    static String formatOutPut(String title, double finalPrice) {
        return title + " - $" + String.format("%.2f", finalPrice);
    }

    public static void main(String[] args) {
        Flux<String> bookTitles = Flux.just(
                "Spring in Action",
                "Reactive Java",
                "Clean Code",
                "Effective Java"
        );

        //* Reactive pipeline
        bookTitles
                .flatMap(title -> getPrice(title)
                        .filter(price -> price < 65)
                        .map(price -> applyDiscount(price, 0.10))
                        .map(discounted -> formatOutPut(title, discounted))
                )
                .subscribe(System.out::println);


    }
}
