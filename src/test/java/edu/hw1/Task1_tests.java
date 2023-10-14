package edu.hw1;

import static edu.hw1.Task1.minutesToSeconds;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1_tests {
    @Test
    @DisplayName("1 минута")
    void test1() {
        // given
        String time = "01:00";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(60);
    }

    @Test
    @DisplayName("Тест 2")
    void test2() {
        // given
        String time = "13:56";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(836);
    }

    @Test
    @DisplayName("Некорректный ввод 1")
    void test3() {
        // given
        String time = "10:60";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Некорректный ввод 2")
    void test4() {
        // given
        String time = "10:-1";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Большое значение")
    void test5() {
        // given
        String time = "999:59";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(59999);
    }

    @Test
    @DisplayName("Только секунды")
    void test6() {
        // given
        String time = "0:10";

        // when
        int seconds = minutesToSeconds(time);

        // then
        assertThat(seconds)
            .isEqualTo(10);
    }
}
