package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("1")
    void test1() {
        // given
        String[] strings = {"a","b","c","a"};
        Task3 t3 = new Task3();

        // when
        Map<String, Integer> ans = t3.freqDict(strings);

        // then
        assertThat(ans)
            .containsEntry("a", 2)
            .containsEntry("b", 1)
            .containsEntry("c", 1);
    }

    @Test
    @DisplayName("2")
    void test2() {
        // given
        String[] strings = {"a","bb","a","bb"};
        Task3 t3 = new Task3();

        // when
        Map<String, Integer> ans = t3.freqDict(strings);

        // then
        assertThat(ans)
            .containsEntry("a", 2)
            .containsEntry("bb", 2);
    }
    @Test
    @DisplayName("3")
    void test3() {
        // given
        String[] strings = {"this","and","that","and"};
        Task3 t3 = new Task3();

        // when
        Map<String, Integer> ans = t3.freqDict(strings);

        // then
        assertThat(ans)
            .containsEntry("this", 1)
            .containsEntry("and", 2)
            .containsEntry("that", 1);
    }

    @Test
    @DisplayName("Ошибка в коде")
    void test4() {
        // given
        String[] strings = {"код", "код", "код", "bug"};
        Task3 t3 = new Task3();

        // when
        Map<String, Integer> ans = t3.freqDict(strings);

        // then
        assertThat(ans)
            .containsEntry("код", 3)
            .containsEntry("bug", 1);
    }
    @Test
    @DisplayName("запутанный")
    void test5() {
        // given
        String[] strings = {"1", "1", "2"};
        Task3 t3 = new Task3();

        // when
        Map<String, Integer> ans = t3.freqDict(strings);

        // then
        assertThat(ans)
            .containsEntry("1", 2)
            .containsEntry("2", 1);
    }
}
