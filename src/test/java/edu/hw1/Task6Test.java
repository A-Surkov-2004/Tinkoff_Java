package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task6.getReversed;
import static edu.hw1.Task6.countK;
import static edu.hw1.Task6.shell;
import static edu.hw1.Task6.toArray;
import static edu.hw1.Task6.toInteger;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {

    @Test
    @DisplayName("Проверка реверса")
    void test1() {
        // given
        int cin = 1230;

        // when
        int ans = getReversed(cin);

        // then
        assertThat(ans)
            .isEqualTo(321);
    }

    @Test
    @DisplayName("Проверка разбиения на цифры")
    void test2() {
        // given
        int cin = 312;

        // when
        Integer[] ans = toArray(cin);

        // then
        assertThat(ans)
            .isEqualTo(new Integer[] {3, 1, 2});
    }

    @Test
    @DisplayName("Проверка перевода в число")
    void test3() {
        // given
        Integer[] v = new Integer[] {3, 2, 1, 0};

        // when
        int ans = toInteger(v);

        // then
        assertThat(ans)
            .isEqualTo(3210);
    }

    @Test
    @DisplayName("Общий тест 1")
    void test4() {
        // given
        int cin = 3524;

        // when
        int ans = countK(cin);

        // then
        assertThat(ans)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Общий тест 2")
    void test5() {
        // given
        int cin = 6621;

        // when
        int ans = shell(cin);

        // then
        assertThat(ans)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Общий тест 3")
    void test6() {
        // given
        int cin = 6554;

        // when
        int ans = shell(cin);

        // then
        assertThat(ans)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Общий тест 4")
    void test7() {
        // given
        int cin = 5837;

        // when
        int ans = shell(cin);

        // then
        assertThat(ans)
            .isEqualTo(7);
    }
}
