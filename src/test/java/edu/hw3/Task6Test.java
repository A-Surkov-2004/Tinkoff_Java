package edu.hw3;

import edu.hw3.Task6.StockMarket;
import edu.hw3.Task6.Stocks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("1 акция")
    void test1() {
        // given
        StockMarket.Stock stock = new StockMarket.Stock("s1", 10);
        Stocks s = new Stocks();
        // when
        s.add(stock);
        StockMarket.Stock ans = s.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(stock);
    }
    @Test
    @DisplayName("Самая дорогая")
    void test2() {
        // given
        StockMarket.Stock s1= new StockMarket.Stock("s1", 10);
        StockMarket.Stock s2= new StockMarket.Stock("s2", 20);
        StockMarket.Stock s3= new StockMarket.Stock("s3", 30);
        Stocks market = new Stocks();
        // when
        market.add(s2);
        market.add(s3);
        market.add(s1);
        StockMarket.Stock ans = market.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(s3);
    }
    @Test
    @DisplayName("Удаление самой дорогой")
    void test3() {
        // given
        StockMarket.Stock s1= new StockMarket.Stock("s1", 10);
        StockMarket.Stock s2= new StockMarket.Stock("s2", 20);
        StockMarket.Stock s3= new StockMarket.Stock("s3", 30);
        Stocks market = new Stocks();
        // when
        market.add(s1);
        market.add(s2);
        market.add(s3);
        market.remove(s3);
        StockMarket.Stock ans = market.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(s2);
    }
}
