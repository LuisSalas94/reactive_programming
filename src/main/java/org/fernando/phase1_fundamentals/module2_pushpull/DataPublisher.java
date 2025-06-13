package org.fernando.phase1_fundamentals.module2_pushpull;

import java.util.ArrayList;
import java.util.List;

public class DataPublisher<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    public void publish(T item) {
        for (Observer<T> observer : observers) {
            observer.onNext(item);
        }
    }
}
