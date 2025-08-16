package org.fernando.phase3_errorhandlingschedulersbackpressure.module2_hotcoldpublisher;

import java.time.LocalTime;

public record StockPrice(String symbol, int price, LocalTime timestamp) {
}
