package org.fernando.phase1_fundamentals.module3_reactivestreams;

import java.util.concurrent.Flow;

// 🧑‍💼 CustomerSubscriber – the diner who controls how much food to receive
public class CustomerSubscriber implements Flow.Subscriber<String> {

    private Flow.Subscription subscription;
    private int dishesToConsume = 2;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("[Customer] Subscribed. Sending order for " + dishesToConsume + " dishes.");
        this.subscription = subscription;
        // Customer places the order (demands items)
        subscription.request(dishesToConsume);
    }

    @Override
    public void onNext(String item) {
        System.out.println("[Customer] Received and eating: " + item);
        dishesToConsume--;
        if (dishesToConsume == 0) {
            // Once satisfied, cancel the subscription
            System.out.println("[Customer] Full. Cancelling order.");
            subscription.cancel();
        }
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println("[Customer] Error occurred: " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("[Customer] All dishes served. Meal complete.");
    }
}
