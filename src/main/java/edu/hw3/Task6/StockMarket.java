package edu.hw3.Task6;

public interface StockMarket {

    void add(Stock stock);

    void remove(Stock stock);

    Stock mostValuableStock();

    record Stock(String name, Integer value) {
        String getName() {
            return name;
        }

        Integer getValue() {
            return value;
        }
    }
}
