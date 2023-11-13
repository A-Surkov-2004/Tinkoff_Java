package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("1925")
    void test1() {
        // given
        Task2 t2 = new Task2();
        int year = 1925;

        // when
        List<String> ans = t2.fridays13InYear(year);

        // then
        assertThat(ans)
            .containsExactly("1925-02-13", "1925-03-13", "1925-11-13");
    }

    @Test
    @DisplayName("2024")
    void test2() {
        // given
        Task2 t2 = new Task2();
        int year = 2024;

        // when
        List<String> ans = t2.fridays13InYear(year);

        // then
        assertThat(ans)
            .containsExactly("2024-09-13", "2024-12-13");
    }

    @Test
    @DisplayName("Первая пятница 13-е 24-го")
    void test3() {
        // given
        Task2 t2 = new Task2();
        Date date = new Date(124, 0, 1);

        // when
        String ans = t2.closestFriday13(date);

        // then
        assertThat(ans)
            .isEqualTo("2024-09-13");
    }

    @Test
    @DisplayName("Вторая пятница 13-е 24-го")
    void test4() {
        // given
        Task2 t2 = new Task2();
        Date date = new Date(124, 10, 1);

        // when
        String ans = t2.closestFriday13(date);

        // then
        assertThat(ans)
            .isEqualTo("2024-12-13");
    }
}
