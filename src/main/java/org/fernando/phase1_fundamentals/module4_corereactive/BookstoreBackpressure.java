package org.fernando.phase1_fundamentals.module4_corereactive;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/*
* The Publisher (bookstore) has 5 books ready to go.
* The Subscriber (reader) only asks for one book at a time, using request(1).
* This is backpressure in action: the subscriber controls the flow.
* Even if the publisher is fast, it waits for the subscriber to request more
* */

public class BookstoreBackpressure {
    public static void main(String[] args) {
        //* Bookstore emits books very fast
        Flux<String> bookStream = Flux.just("Book A", "Book B", "Book C", "Book D", "Book E");

        //* A custom subscriber (the reader) processes one book at a time
        bookStream.subscribe(new BaseSubscriber<String>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                System.out.println("Reader subscribed. Asking for 1 book...");
                request(1); // Ask for the first book
            }

            @Override
            protected void hookOnNext(String book) {
                System.out.println("Reader is reading : " + book);
                try {
                    Thread.sleep(1000); // Simulate slow reading
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Done reading: " + book + ". Asking for next book...\n");
                request(1); // Ask for the next book
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("All books read!");
            }
        });
    }
}
