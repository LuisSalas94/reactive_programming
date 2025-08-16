package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

public class HotPublisherExample {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    //* Example 1: publish().connect() - Manual Hot Publisher
    //* You control when the source starts emitting
    private static void publishConnectExample() throws InterruptedException {
        System.out.println("--- Example 1: publish().connect() Approach ---");
        var stockPriceCounter = new AtomicInteger(100);
        //* Create a ConnectableFlux - it's HOT but NOT started yet
        ConnectableFlux<StockPrice> stockFeed = Flux.interval(Duration.ofMillis(400))
                .map(tick -> {
                    int currentPrice = stockPriceCounter.addAndGet((int) (Math.random() * 10 - 5));
                    var price = new StockPrice("AAPL", currentPrice, LocalTime.now());
                    System.out.println("Live: AAPL = $" + price.price() + " at " + price.timestamp().format(TIME_FORMATTER));
                    return price;
                }).publish(); //* Creates ConnectableFlux - Hot but dormant

        //* Add subscriber before connecting
        stockFeed.subscribe(price -> System.out.println(" Subscriber 1: $" + price.price()));
        stockFeed.subscribe(price -> System.out.println(" Subscriber 2: $" + price.price()));
        Thread.sleep(1000);
        //* THIS starts the actual data flow
        stockFeed.connect();
        Thread.sleep(1500);

        System.out.println("\nLate subscriber joins running feed...");
        stockFeed.subscribe(price -> System.out.println("Late subscriber: $" + price.price() + "(missed earlier data!)"));
        Thread.sleep(1500);
        System.out.println("--- End of publisher().connect() example ---\n");
    }

    //* Example 2: share() - Automatic Hot Publisher
    private static void shareExample() throws InterruptedException {
        System.out.println("--- Example 2: share() Approach ---");
        System.out.println("Feed starts automatically when first subscriber joins!");
        var stockPriceCounter = new AtomicInteger(200);

        //* Hot Flux using share() - starts when first subscriber joins
        Flux<StockPrice> stockFeed = Flux.interval(Duration.ofMillis(400))
                .map(tick -> {
                    int currentPrice = stockPriceCounter.addAndGet((int) (Math.random() * 8 - 4));
                    var price = new StockPrice("GOOGL", currentPrice, LocalTime.now());
                    System.out.println("Live: GOOGL = $" + price.price() + " at " + price.timestamp().format(TIME_FORMATTER));
                    return price;
                })
                .share(); //* Automatically HOT - starts with first subscriber

        System.out.println("Hot Flux created with share()");
        Thread.sleep(500);

        System.out.println("First Subscriber joining - this STARTS the feed");
        stockFeed.subscribe(price -> System.out.println("First Sub: $" + price.price()));
        Thread.sleep(1200);

        System.out.println("Second Subscriber joining");
        stockFeed.subscribe(price -> System.out.println("Second Sub: $" + price.price()));
        Thread.sleep(1200);

        System.out.println("Third Subscriber joining -  very late");
        stockFeed.subscribe(price -> System.out.println("Third Sub: $" + price.price() + "(missed lots of data)"));
        Thread.sleep(1000);

        System.out.println("--- End of share() example ---");

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Hot Publisher Demo: Two Approaches ===\n");

        //* Example 1: publish().connect() approach
//        publishConnectExample();
//        Thread.sleep(1000);

        //* Example 2: share() approach
        shareExample();

    }
}
