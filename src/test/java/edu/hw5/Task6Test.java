package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("True 1")
    void test1() {
        // given
        Task6 t6 = new Task6();

        // when
        boolean ans = t6.isSubstring("abc","achfdbaabgabcaabg");

        // then
        assertThat(ans)
            .isTrue();
    }

    @Test
    @DisplayName("False 1")
    void test2() {
        // given
        Task6 t6 = new Task6();

        // when
        boolean ans = t6.isSubstring("abc","achfdbaabgabaabg");

        // then
        assertThat(ans)
            .isFalse();
    }
}
