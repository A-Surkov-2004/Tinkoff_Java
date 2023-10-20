package edu.hw1;

import static edu.hw1.Task2.countDigits;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    @DisplayName("Тест 1")
    void test1() {
        // given
        int number = 4666;

        // when
        int ans = countDigits(number);

        // then
        assertThat(ans)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Тест 2")
    void test2() {
        // given
        int number = 544;

        // when
        int ans = countDigits(number);

        // then
        assertThat(ans)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Нуль")
    void test3() {
        // given
        int number = 0;

        // when
        int ans = countDigits(number);

        // then
        assertThat(ans)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Отрицательное")
    void test4() {
        // given
        int number = -54;

        // when
        int ans = countDigits(number);

        // then
        assertThat(ans)
            .isEqualTo(2);
    }
}
