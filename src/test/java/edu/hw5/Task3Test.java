package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    @DisplayName("- 1")
    void test1() {
        // given
        Task3 t3 = new Task3();
        String date = "2020-10-10";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo("2020-10-10");
    }

    @Test
    @DisplayName("- 2")
    void test2() {
        // given
        Task3 t3 = new Task3();
        String date = "2020-12-2";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo("2020-12-02");
    }

    @Test
    @DisplayName("/ 1")
    void test3() {
        // given
        Task3 t3 = new Task3();
        String date = "1/3/1976";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo("1976-03-01");
    }

    @Test
    @DisplayName("/ 2")
    void test4() {
        // given
        Task3 t3 = new Task3();
        String date = "2/5/10";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo("2010-05-02");
    }

    @Test
    @DisplayName("завтра")
    void test5() {
        // given
        Task3 t3 = new Task3();
        String date = "tomorrow";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo(LocalDate.now().plusDays(1).toString());
    }

    @Test
    @DisplayName("Сегодня")
    void test6() {
        // given
        Task3 t3 = new Task3();
        String date = "today";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo(LocalDate.now().toString());
    }

    @Test
    @DisplayName("Вчера")
    void test7() {
        // given
        Task3 t3 = new Task3();
        String date = "yesterday";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo(LocalDate.now().minusDays(1).toString());
    }

    @Test
    @DisplayName("n дней назад")
    void test8() {
        // given
        Task3 t3 = new Task3();
        String date = "2234 days ago";

        // when
        String ans = t3.parseDate(date).orElse(LocalDate.now()).toString();

        // then
        assertThat(ans)
            .isEqualTo(LocalDate.now().minusDays(2234).toString());
    }
}
