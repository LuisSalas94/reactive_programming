package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ColdPublisherExample {

    public static void main(String[] args) throws InterruptedException {
        //* Counter to track how many times the db is called
        var databaseCallCounter = new AtomicInteger(0);
        System.out.println("=== Cold Publisher Demo: Database Book Fetch ===");
        System.out.println("Watch how each subscriber triggers its OWN database call!\n");

        //* COLD MONO: Each subscription executes the supplier independently
        Mono<Book> coldBookMono = Mono.fromSupplier(() -> {
            //* This code runs EVERY TIME someone subscribes
            int callNumber = databaseCallCounter.incrementAndGet();
            System.out.println("Database call # " + callNumber + " - Fresh execution started");
            //* Simulate database query delay
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            var book = new Book("Reactive Programming Vol." + callNumber, "Author-" + callNumber, LocalDateTime.now());
            System.out.println("Database returned: " + book.title() + " (Call #" + callNumber + ")");
            return book;
        });

        //* Proof: Each subscriber get independent execution
        System.out.println("\n--- Subscriber 1 subscribing ---");
        coldBookMono.subscribe(book -> System.out.println("Subscriber 1 received: " + book.title()));
        Thread.sleep(100);

        System.out.println("\n--- Subscriber 2 subscribing ---");
        coldBookMono.subscribe(book -> System.out.println("Subscriber 2 received: " + book.title()));
        Thread.sleep(100);

        System.out.println("\n--- Subscriber 3 subscribing ---");
        coldBookMono.subscribe(book -> System.out.println("Subscriber 3 received: " + book.title()));
        Thread.sleep(100);

        System.out.println("\nResult: 3 subscriber = " + databaseCallCounter.get() + " database calls");
        System.out.println("This proved it's COLD - each subscriber triggers fresh execution");


    }
}
