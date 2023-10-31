package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Начало")
    void test1() {
        // given
        String str = "a";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("z");
    }

    @Test
    @DisplayName("Конец")
    void test2() {
        // given
        String str = "z";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("a");
    }

    @Test
    @DisplayName("Капс")
    void test3() {
        // given
        String str = "X";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("C");
    }

    @Test
    @DisplayName("Середина")
    void test4() {
        // given
        String str = "mn";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("nm");
    }

    @Test
    @DisplayName("Сторонний символ")
    void test5() {
        // given
        String str = "Svool dliow!";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("Hello world!");
    }

    @Test
    @DisplayName("Длинный текст")
    void test6() {
        // given
        String str = "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";
        Task1 t1 = new Task1();

        // when
        String ans = t1.atbash(str);

        // then
        assertThat(ans)
            .isEqualTo("Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
    }
}
