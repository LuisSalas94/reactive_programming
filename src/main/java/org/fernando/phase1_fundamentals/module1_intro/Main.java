package org.fernando.phase1_fundamentals.module1_intro;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        List<Book> books = List.of(
//                new Book("Reactive Design Patterns", "Tech"),
//                new Book("The Hobbit", "Fantasy"),
//                new Book("Clean Code", "Tech"),
//                new Book("Lord of the Rings", "Fantasy")
//        );
//
//        List<Book> fantasyBooks = ImperativeBookProcessor.filterBooksByGenre(books, "Fantasy");
//        List<String> upperTitles = ImperativeBookProcessor.transformTitlesToUpper(fantasyBooks);
//
//        for (String title : upperTitles) {
//            System.out.println(title);
//        }

        ReactiveBookProcessor.getBooksStream()
                .filter(book -> book.getGenre().equalsIgnoreCase("Fantasy"))
                .map(book -> new Book(book.getTitle().toUpperCase(), book.getGenre()))
                .doOnNext(book -> System.out.println("Processing book: " + book))
                .doOnError(error -> System.out.println("Error encountered: " + error))
                .doOnComplete(() -> System.out.println("Processing complete"))
                .subscribe();
        // // Keep the JVM alive for async processing (demo purpose)
        Thread.sleep(10000);
    }
}
