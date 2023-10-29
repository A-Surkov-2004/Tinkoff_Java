package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("1 акция")
    void test1() {
        // given
        Task6.Stock stock = new Task6.Stock("s1", 10);
        Task6 t6 = new Task6();
        Task6.Stocks s = t6.new Stocks();
        // when
        s.add(stock);
        Task6.Stock ans = s.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(stock);
    }

    @Test
    @DisplayName("Самая дорогая")
    void test2() {
        // given
        Task6.Stock s1= new Task6.Stock("s1", 10);
        Task6.Stock s2= new Task6.Stock("s2", 20);
        Task6.Stock s3= new Task6.Stock("s3", 30);
        Task6 t6 = new Task6();
        Task6.Stocks market = t6.new Stocks();
        // when
        market.add(s2);
        market.add(s3);
        market.add(s1);
        Task6.Stock ans = market.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(s3);
    }
    @Test
    @DisplayName("Удаление самой дорогой")
    void test3() {
        // given
        Task6.Stock s1= new Task6.Stock("s1", 10);
        Task6.Stock s2= new Task6.Stock("s2", 20);
        Task6.Stock s3= new Task6.Stock("s3", 30);
        Task6 t6 = new Task6();
        Task6.Stocks market = t6.new Stocks();
        // when
        market.add(s1);
        market.add(s2);
        market.add(s3);
        market.remove(s3);
        Task6.Stock ans = market.mostValuableStock();

        // then
        assertThat(ans)
            .isEqualTo(s2);
    }
}
