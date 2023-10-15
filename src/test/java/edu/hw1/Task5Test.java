package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task5.isPalindromeDescendant;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    @DisplayName("Сумма больше 9")
    void test1() {
        // given
        int cin = 335633;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Тест 2")
    void test2() {
        // given
        int cin = 11211230;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Тест 3")
    void test3() {
        // given
        int cin = 13001120;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Тест 4")
    void test4() {
        // given
        int cin = 23336014;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Тест 5")
    void test5() {
        // given
        int cin = 11;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Ответ false")
    void test6() {
        // given
        int cin = 1213;

        // when
        boolean ans = isPalindromeDescendant(cin);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }
}

