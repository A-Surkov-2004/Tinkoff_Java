package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw1.Task3.isNestable;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    @DisplayName("Тест 1")
    void test1() {
        // given
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {0, 6};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Обратный тест")
    void test2() {
        // given
        int[] a = new int[] {0, 6};
        int[] b = new int[] {1, 2, 3, 4, 5};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Тест 3")
    void test3() {
        // given
        int[] a = new int[] {3,1};
        int[] b = new int[] {4,0};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Тест 4")
    void test4() {
        // given
        int[] a = new int[] {9, 9, 8};
        int[] b = new int[] {8, 9};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Тест 5")
    void test5() {
        // given
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {2, 3};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }


    @Test
    @DisplayName("Равные массивы")
    void test6() {
        // given
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {1, 2, 3, 4};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Один элемент")
    void test7() {
        // given
        int[] a = new int[] {1};
        int[] b = new int[] {2};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Один элемент (обратный тест)")
    void test8() {
        // given
        int[] a = new int[] {2};
        int[] b = new int[] {1};

        // when
        boolean ans = isNestable(a, b);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

}
