package edu.hw3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Task6 {
    Task6() {
    }

    PriorityQueue<Stock> priorityQueue = new PriorityQueue<>(new MyComparator());

    public record Stock(String name, Integer value) {
    }

    static class MyComparator implements Comparator<Stock> {
        @Override
        public int compare(Stock o1, Stock o2) {
            return o2.value.compareTo(o1.value);
        }
    }

    interface StockMarket {
        void add(Stock stock);

        void remove(Stock stock);

        Stock mostValuableStock();
    }

    public class Stocks implements StockMarket {
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
}
