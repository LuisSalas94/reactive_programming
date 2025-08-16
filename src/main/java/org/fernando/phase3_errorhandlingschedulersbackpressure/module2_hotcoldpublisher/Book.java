package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import java.time.LocalDateTime;

public record Book(String title, String author, LocalDateTime fetchAt) {
}
