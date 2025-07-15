package org.fernando.phase1_fundamentals.module4_corereactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/*
* Book A and Book B are sent before
* Subscriber 2 joins → only Subscriber 1 gets them.
* Book C is sent immediately after Subscriber 2 joins →
* both are now active, so both receive it.
* Same with Book D.
* */

public class HotPublisherBookstore {
    public static void main(String[] args) throws InterruptedException {
        FluxSink<String>[] sinkRef = new FluxSink[1];
        // Create a Flux that lets us push data manually
        Flux<String> bookStream = Flux.create(sink -> {
            sinkRef[0] = sink; // Save the sink so we can push data later
        });

        // Make it a hot publisher by sharing it
        Flux<String> hotBookStream = bookStream.share();

        // First Subscriber joins
        hotBookStream.subscribe(book -> System.out.println("Subscriber 1: " + book));

        // Emit books - only Subscriber 1 gets these
        sinkRef[0].next("Book A");
        sinkRef[0].next("Book B");

        // Second Subscribers joins
        hotBookStream.subscribe(book -> System.out.println("Subscriber 2: " + book));

        // Emit more books - now both subscribers get them
        sinkRef[0].next("Book C");
        sinkRef[0].next("Book D");

        // Complete the stream
        sinkRef[0].complete();

        Thread.sleep(10000); // Time to print
    }
}
