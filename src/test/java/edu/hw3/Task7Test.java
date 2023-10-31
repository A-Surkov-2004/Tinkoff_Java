package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("ключ null")
    void test1() {
        // given
        Task7 t7 = new Task7();
        Task7.Tree tree = t7.new Tree();
        // when
        tree.add(null, "Hello World");

        // then
        assertThat(tree.map.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("2 элемента")
    void test2() {
        // given
        Task7 t7 = new Task7();
        Task7.Tree tree = t7.new Tree();
        // when
        tree.add(null, "Hello World");
        tree.add("NotNull", "Goodbye World");

        // then
        assertThat(tree.map.get(null)).isEqualTo("Hello World");
        assertThat(tree.map.get("NotNull")).isEqualTo("Goodbye World");
    }
}
