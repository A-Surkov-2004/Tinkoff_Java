package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Первый = последний T1")
    void test1() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.firstEqualsLast("101");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Первый = последний T2")
    void test2() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.firstEqualsLast("010");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Первый = последний T3")
    void test3() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.firstEqualsLast("1");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Первый = последний F1")
    void test4() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.firstEqualsLast("110");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("Длина 1-3 T1")
    void test5() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.oneToThree("1");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Длина 1-3 T2")
    void test6() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.oneToThree("10");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Длина 1-3 T3")
    void test7() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.oneToThree("101");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("Длина 1-3 F1")
    void test8() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.oneToThree("");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("Длина 1-3 F2")
    void test9() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.oneToThree("1010");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("??0* T1")
    void test10() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.twoThenZero("000");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("??0* T2")
    void test11() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.twoThenZero("1100");

        // then
        assertThat(ans)
            .isTrue();
    }
    @Test
    @DisplayName("??0* F1")
    void test12() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.twoThenZero("1110");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("??0* F2")
    void test13() {
        // given
        Task7 t7 = new Task7();

        // when
        boolean ans = t7.twoThenZero("11");

        // then
        assertThat(ans)
            .isFalse();
    }
}
