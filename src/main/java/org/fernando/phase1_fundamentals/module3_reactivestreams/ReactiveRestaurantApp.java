package org.fernando.phase1_fundamentals.module3_reactivestreams;

public class ReactiveRestaurantApp {
    public static void main(String[] args) throws InterruptedException {
        DishPublisher kitchen = new DishPublisher();          // Publisher
        WaiterProcessor waiter = new WaiterProcessor();       // Processor (intermediate handler)
        CustomerSubscriber customer = new CustomerSubscriber(); // Subscriber

        // Setup chain: Kitchen → Waiter → Customer
        kitchen.subscribe(waiter);
        waiter.subscribe(customer);

        // Let system complete asynchronously
        Thread.sleep(2000);

     /*
        🍽️ Execution Summary:
        - Kitchen (Publisher) offers dishes from a menu.
        - Waiter (Processor) filters out Sushi before passing to the customer.
        - Customer (Subscriber) requests 2 dishes.
        - When full, the customer cancels the subscription.
        - The kitchen respects cancellation and stops preparing food.
     */
    }
}
