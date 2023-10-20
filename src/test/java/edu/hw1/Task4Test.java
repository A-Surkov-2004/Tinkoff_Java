package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task4.fixString;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Тест 1")
    void test1() {
        // given
        String str = "123456";

        // when
        String ans = fixString(str);

        // then
        assertThat(ans)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Тест 2")
    void test2() {
        // given
        String str = "hTsii  s aimex dpus rtni.g";

        // when
        String ans = fixString(str);

        // then
        assertThat(ans)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Тест 3")
    void test3() {
        // given
        String str = "badce";

        // when
        String ans = fixString(str);

        // then
        assertThat(ans)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Тест 4")
    void test4() {
        // given
        String str = "оПомигети псаривьтс ртко!и";

        // when
        String ans = fixString(str);

        // then
        assertThat(ans)
            .isEqualTo("Помогите исправить строки!");
    }
}
