package org.fernando.phase1_fundamentals.module5_reactiveerror;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class ReactiveSignalLifecycle {
    public static void main(String[] args) {
        // Publisher: Emits a stream of books
        Flux<String> bookPublisher = Flux.just("Book A", "Book B", "Book C", "Book D");

        // Subscriber: Defines how to handle signals
        bookPublisher.subscribe(new Subscriber<String>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                System.out.println("onSubscribe: Subscribed to the publisher");
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(String book) {
                System.out.println("onNext: Received " + book);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete: All books received");
            }
        });
    }
}
