package org.fernando.phase1_fundamentals.module3_reactivestreams;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class WaiterProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("[Waiter] Subscribed to kitchen.");
        this.subscription = subscription;
        // Request the first dish
        subscription.request(1);
    }

    @Override
    public void onNext(String dish) {
        if (dish.equalsIgnoreCase("Sushi")) {
            System.out.println("[Waiter] Oh! Customer allergic to Sushi. Skipping...");
            // Skip and request another
            subscription.request(1);
            return;
        }

        // Forward acceptable dishes to the customer
        submit(dish);
        // Request next dish after forwarding
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        closeExceptionally(throwable);
    }

    @Override
    public void onComplete() {
        close();
        System.out.println("[Waiter] All dishes served.");
    }
}
