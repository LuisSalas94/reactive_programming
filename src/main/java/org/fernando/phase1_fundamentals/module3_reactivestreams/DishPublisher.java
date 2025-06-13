package org.fernando.phase1_fundamentals.module3_reactivestreams;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;

// 🧑‍🍳 DishPublisher – the kitchen that prepares dishes on demand
public class DishPublisher implements Flow.Publisher<String> {
    private final String[] menu = {"Steak", "Salad", "Pasta", "Sushi", "Pizza", "Soup"};

    @Override
    public void subscribe(Flow.Subscriber<? super String> subscriber) {
        System.out.println("[Kitchen] New customer subscribing...");
        subscriber.onSubscribe(new DishSubscription(subscriber));
    }

    // DishSubscription manages request/cancel between customer and kitchen
    private class DishSubscription implements Flow.Subscription {
        private final Flow.Subscriber<? super String> subscriber;
        private int currentIndex = 0;
        private final AtomicBoolean isCanceled = new AtomicBoolean(false);

        private DishSubscription(Flow.Subscriber<? super String> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public void request(long n) {
            if (n <= 0) {
                subscriber.onError(new IllegalArgumentException("Demand must be > 0"));
                return;
            }

            // Backpressure-aware emission: respect demand and menu bounds
            for (long i = 0; i < n && currentIndex < menu.length; i++) {
                if (isCanceled.get()) {
                    System.out.println("[Kitchen] Subscription cancelled. Stopping dish preparation.");
                    return;
                }

                String dish = menu[currentIndex++];
                System.out.println("[Kitchen] Preparing dish: " + dish);
                subscriber.onNext(dish);
            }

            // Notify when all dishes are served
            if (currentIndex == menu.length && !isCanceled.get()) {
                subscriber.onComplete();
            }
        }

        @Override
        public void cancel() {
            isCanceled.set(true);
            System.out.println("[Kitchen] Order cancelled by customer.");
        }
    }
}
