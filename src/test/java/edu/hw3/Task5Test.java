package edu.hw3;

import edu.hw3.Task5.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Возрастание")
    void test1() {
        // given
        String[] s = new String[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"};
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        Task5.Contacts[] rans = t5.parseContacts(new String[]{"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"}, "");
        assertThat(ans)
            .isEqualTo(rans);
    }
    @Test
    @DisplayName("Убывание")
    void test2() {
        // given
        String[] s = new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"};
        String method = "DESC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        Task5.Contacts[] rans = t5.parseContacts(new String[]{"Carl Gauss", "Leonhard Euler", "Paul Erdos"}, "");
        assertThat(ans)
            .isEqualTo(rans);
    }
    @Test
    @DisplayName("Семья")
    void test3() {
        // given
        String[] s = new String[] {"Thomas Aquinas", "Rene Aquinas", "David Aquinas", "John Aquinas"};
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        Task5.Contacts[] rans = t5.parseContacts(new String[]{"David Aquinas", "John Aquinas",  "Rene Aquinas", "Thomas Aquinas"}, "");
        assertThat(ans)
            .isEqualTo(rans);
    }

    @Test
    @DisplayName("Только Имя")
    void test4() {
        // given
        String[] s = new String[] {"Thomas", "Rene", "David", "John"};
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        Task5.Contacts[] rans = t5.parseContacts(new String[]{"David", "John",  "Rene", "Thomas"}, "");
        assertThat(ans)
            .isEqualTo(rans);
    }

    @Test
    @DisplayName("Имя как фамилия")
    void test5() {
        // given
        String[] s = new String[] {"Thomas Gauss", "Rene Descartes", "David", "John Locke"};
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        Task5.Contacts[] rans = t5.parseContacts(new String[]{"David", "Rene Descartes", "Thomas Gauss", "John Locke"}, "");
        assertThat(ans)
            .isEqualTo(rans);
    }
    @Test
    @DisplayName("Пустой")
    void test6() {
        // given
        String[] s = new String[] {};
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        assertThat(ans)
            .containsExactly();
    }
    @Test
    @DisplayName("Null")
    void test7() {
        // given
        String[] s = null;
        String method = "ASC";
        Task5 t5 = new Task5();

        // when
        Task5.Contacts[] ans = t5.parseContacts(s, method);

        // then
        assertThat(ans)
            .containsExactly();
    }
}
