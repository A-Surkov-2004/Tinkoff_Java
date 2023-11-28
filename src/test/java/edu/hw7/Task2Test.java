package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    void test1() {
        // given
        int n = 5;
        Task2 t2 = new Task2();

        // when
        BigInteger ans = t2.factorial(n);

        // then
        assertThat(ans)
            .isEqualTo(120);
    }

    @Test
    void test2() {
        // given
        int n = 10;
        Task2 t2 = new Task2();

        // when
        BigInteger ans = t2.factorial(n);

        // then
        assertThat(ans)
            .isEqualTo(3_628_800);
    }

    @Test
    @DisplayName("Больше, чем int")
    void test3() {
        // given
        int n = 30;
        Task2 t2 = new Task2();

        // when
        BigInteger ans = t2.factorial(n);

        // then
        assertThat(ans.toString())
            .isEqualTo("265252859812191058636308480000000");
    }

    /*
    @Test
    @DisplayName("сравнение времени исполнения")
    void test4() {
        // given
        int n = 100_000;
        Task2 t2 = new Task2();

        // when
        BigInteger ans = t2.factorial(n);


        // then
        assertThat(ans.toString())
            .isEqualTo(""); // 11 страниц текста
    }
     */
}
