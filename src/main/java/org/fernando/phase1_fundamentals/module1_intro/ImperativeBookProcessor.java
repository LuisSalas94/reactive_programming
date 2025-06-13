package org.fernando.phase1_fundamentals.module1_intro;

import java.util.ArrayList;
import java.util.List;

public class ImperativeBookProcessor {
    public static List<Book> filterBooksByGenre(List<Book> books, String genre) {
        List<Book> filtered = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    public static List<String> transformTitlesToUpper(List<Book> books) {
        List<String> titles = new ArrayList<>();
        for (Book book : books) {
            titles.add(book.getTitle().toUpperCase());
        }
        return titles;
    }
}
