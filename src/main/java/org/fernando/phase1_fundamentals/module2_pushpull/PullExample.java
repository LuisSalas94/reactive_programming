package org.fernando.phase1_fundamentals.module2_pushpull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PullExample {
    public static void main(String[] args) {
        List<String> data = Arrays.asList("Maria", "Linda", "Claudia");
        Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Pulled: " + name);
        }
    }
}
