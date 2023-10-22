package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("f()")
    void test1() throws Exception {
        // given
        Task4 t = new Task4();

        // when
        Task4.CallingInfo ans = t.catcher();

        // then
        assertThat(ans).isEqualTo(new Task4.CallingInfo("Task4", "f"));
    }
}
