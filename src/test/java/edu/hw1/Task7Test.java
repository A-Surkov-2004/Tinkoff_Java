package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task7.rotateLeft;
import static edu.hw1.Task7.rotateRight;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {

    @Test
    @DisplayName("Левый 1")
    void test1() {
        // given
        int n = 16;
        int shift = 1;

        // when
        int ans = rotateLeft(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Левый 2")
    void test2() {
        // given
        int n = 17;
        int shift = 2;

        // when
        int ans = rotateLeft(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Правый 1")
    void test3() {
        // given
        int n = 8;
        int shift = 1;

        // when
        int ans = rotateRight(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Правый 2")
    void test4() {
        // given
        int n = 17;
        int shift = 2;

        // when
        int ans = rotateRight(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(12);
    }

    @Test
    @DisplayName("Полный оборот")
    void test5() {
        // given
        int n = 17;
        int shift = 5;

        // when
        int ans = rotateRight(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(17);
    }
    @Test
    @DisplayName("Полный оборот +1")
    void test6() {
        // given
        int n = 17;
        int shift = 6;

        // when
        int ans = rotateRight(n, shift);

        // then
        assertThat(ans)
            .isEqualTo(24);
    }
}
