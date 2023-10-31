package edu.hw3.Task6;

import java.util.Comparator;

class StockComparator implements Comparator<StockMarket.Stock> {
    @Override
    public int compare(StockMarket.Stock o1, StockMarket.Stock o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
