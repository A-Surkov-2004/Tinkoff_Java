package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("False")
    void test1() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcccccd");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("~")
    void test2() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc~ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("!")
    void test3() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc!ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Первый символ")
    void test4() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("!aabbccccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Последний символ")
    void test5() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbccccd!");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Первый и последний символ")
    void test6() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("!aabbccccd!");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Множество символов")
    void test7() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aa!!bbcc~~ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("@")
    void test8() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc@ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("#")
    void test9() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc#ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("$")
    void test10() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc$ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("%")
    void test11() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc%ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("^")
    void test12() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc^ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("&")
    void test13() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc&ccd");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("*")
    void test14() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc*ccd");

        // then
        assertThat(ans)
            .isTrue();
    }
    @Test
    @DisplayName("|")
    void test15() {
        // given
        Task4 t4 = new Task4();

        // when
        boolean ans = t4.passwordValidation("aabbcc|ccd");

        // then
        assertThat(ans)
            .isTrue();
    }
}
