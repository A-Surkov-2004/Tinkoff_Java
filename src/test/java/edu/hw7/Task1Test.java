package edu.hw7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void test1() {
        for (int i = 0; i < 1000; i++) {
            // given
            int n = 5;
            Task1 t1 = new Task1();



            // when
            int ans = t1.counter(n);

            // then
            assertThat(ans)
                .isEqualTo(n*2);
        }
    }
}
