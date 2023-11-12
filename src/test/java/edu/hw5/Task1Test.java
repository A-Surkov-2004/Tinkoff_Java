package edu.hw5;

import edu.hw5.Task1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("3 40")
    void test1() {
        // given
        String[] given = new String[2];
        given[0] = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        given[1] = "2022-04-01, 21:30 - 2022-04-02, 01:20";

        edu.hw5.Task1 t1 = new Task1();

        // when
        String ans = t1.sessionTime(given);

        // then
        assertThat(ans)
            .isEqualTo("3ч 40м");
    }

    @Test
    @DisplayName("1 строка")
    void test2() {
        // given
        String[] given = new String[1];
        given[0] = "2022-03-12, 20:20 - 2022-03-12, 23:50";

        edu.hw5.Task1 t1 = new Task1();

        // when
        String ans = t1.sessionTime(given);

        // then
        assertThat(ans)
            .isEqualTo("3ч 30м");
    }

    @Test
    @DisplayName("2 дня")
    void test3() {
        // given
        String[] given = new String[1];
        given[0] = "2022-03-12, 20:20 - 2022-03-14, 20:20";

        edu.hw5.Task1 t1 = new Task1();

        // when
        String ans = t1.sessionTime(given);

        // then
        assertThat(ans)
            .isEqualTo("48ч ");
    }

    @Test
    @DisplayName("0 секунд")
    void test4() {
        // given
        String[] given = new String[1];
        given[0] = "2022-03-12, 20:20 - 2022-03-12, 20:20";

        edu.hw5.Task1 t1 = new Task1();

        // when
        String ans = t1.sessionTime(given);

        // then
        assertThat(ans)
            .isEqualTo("0с");
    }

    @Test
    @DisplayName("Пустой")
    void test5() {
        // given
        String[] given = new String[0];

        edu.hw5.Task1 t1 = new Task1();

        // when
        String ans = t1.sessionTime(given);

        // then
        assertThat(ans)
            .isEqualTo("0с");
    }
}
