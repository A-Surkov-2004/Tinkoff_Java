package edu.hw3.Task6;

import java.util.PriorityQueue;

public class Stocks implements StockMarket {
    PriorityQueue<Stock> priorityQueue = new PriorityQueue<>(new StockComparator());

    @Override
    public void add(Stock stock) {
        priorityQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        priorityQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return priorityQueue.peek();
    }
}
