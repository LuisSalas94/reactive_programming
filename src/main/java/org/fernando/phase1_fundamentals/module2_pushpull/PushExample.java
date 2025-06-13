package org.fernando.phase1_fundamentals.module2_pushpull;

public class PushExample {
    public static void main(String[] args) {
        DataPublisher<String> publisher = new DataPublisher<>();
        publisher.subscribe(item -> System.out.println("Received: " + item));
        publisher.publish("Maria");
        publisher.publish("Linda");
        publisher.publish("Claudia");
    }
}
