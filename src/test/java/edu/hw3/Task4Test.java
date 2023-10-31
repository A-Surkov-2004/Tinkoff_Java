package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Девятки")
    void test1() {
        // given
        int arabic = 1999;
        Task4 t4 = new Task4();

        // when
        String ans = t4.convertToRoman(arabic);

        // then
        assertThat(ans)
            .isEqualTo("MCMXCIX");
    }

    @Test
    @DisplayName("Четвёрки")
    void test2() {
        // given
        int arabic = 1444;
        Task4 t4 = new Task4();

        // when
        String ans = t4.convertToRoman(arabic);

        // then
        assertThat(ans)
            .isEqualTo("MCDXLIV");
    }

    @Test
    @DisplayName("Единицы")
    void test4() {
        // given
        int arabic = 1111;
        Task4 t4 = new Task4();

        // when
        String ans = t4.convertToRoman(arabic);

        // then
        assertThat(ans)
            .isEqualTo("MCXI");
    }

    @Test
    @DisplayName("Тройки")
    void test5() {
        // given
        int arabic = 333;
        Task4 t4 = new Task4();

        // when
        String ans = t4.convertToRoman(arabic);

        // then
        assertThat(ans)
            .isEqualTo("CCCXXXIII");
    }
}
