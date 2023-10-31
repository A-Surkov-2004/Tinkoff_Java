package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("2 кластера")
    void test1() {
        // given
        String str = "()()";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("()", "()");
    }

    @Test
    @DisplayName("сложный кластер")
    void test2() {
        // given
        String str = "()(())";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("()", "(())");
    }
    @Test
    @DisplayName("вложенные скобки")
    void test3() {
        // given
        String str = "()(())(()())";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("()", "(())", "(()())");
    }
    @Test
    @DisplayName("Тест 4")
    void test4() {
        // given
        String str = "((()))(())()()(()())";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("((()))", "(())", "()", "()", "(()())");
    }

    @Test
    @DisplayName("Тест 5")
    void test5() {
        // given
        String str = "((())())(()(()()))";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("((())())", "(()(()()))");
    }

    @Test
    @DisplayName("Пустая строка")
    void test6() {
        // given
        String str = "";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly();
    }


    @Test
    @DisplayName("Строка null")
    void test7() {
        // given
        String str = "";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly();
    }

    @Test
    @DisplayName("Мусорная строка")
    void test8() {
        // given
        String str = "(х)цУ((ч)ф(ц)а)";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("(х)","ц","У","((ч)ф(ц)а)");
    }

    @Test
    @DisplayName("несбалансированная строка")
    void test9() {
        // given
        String str = "(()))()";
        Task2 t2 = new Task2();

        // when
        List<String> ans = t2.clusterize(str);

        // then
        assertThat(ans)
            .containsExactly("");
    }
}
