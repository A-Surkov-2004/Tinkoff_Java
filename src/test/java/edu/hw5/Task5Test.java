package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("True 1")
    void test1() {
        // given
        Task5 t5 = new Task5();

        // when
        boolean ans = t5.carPlateValidation("А123ВЕ777");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("True 2")
    void test2() {
        // given
        Task5 t5 = new Task5();

        // when
        boolean ans = t5.carPlateValidation("О777ОО177");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("False 1")
    void test3() {
        // given
        Task5 t5 = new Task5();

        // when
        boolean ans = t5.carPlateValidation("123АВЕ777");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("False 2")
    void test4() {
        // given
        Task5 t5 = new Task5();

        // when
        boolean ans = t5.carPlateValidation("А123ВГ77");

        // then
        assertThat(ans)
            .isFalse();
    }

    @Test
    @DisplayName("False 3")
    void test5() {
        // given
        Task5 t5 = new Task5();

        // when
        boolean ans = t5.carPlateValidation("А123ВЕ7777");

        // then
        assertThat(ans)
            .isFalse();
    }
}
