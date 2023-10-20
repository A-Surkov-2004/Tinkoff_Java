package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanTest {
    @Test
    @DisplayName("Получение слова")
    void test1() {
        // given
        String word;
        ConsoleHangman hangman = new ConsoleHangman();

        // when
        word = hangman.getWord();

        // then
        assertThat(word.length())
            .isGreaterThan(0);
    }

    @Test
    @DisplayName("Открытие первого символа")
    void test2() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        String guess = "a";
        hangman.word = "abcd";
        hangman.currentWord = new char[] {'*', '*', '*', '*'};

        // when
        hangman.guessing(guess);

        // then
        assertThat(hangman.currentWord)
            .containsExactly('a', '*', '*', '*');
    }

    @Test
    @DisplayName("Открытие последнего символа")
    void test3() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        String guess = "d";
        hangman.word = "abcd";
        hangman.currentWord = new char[] {'*', '*', '*', '*'};

        // when
        hangman.guessing(guess);

        // then
        assertThat(hangman.currentWord)
            .containsExactly('*', '*', '*', 'd');
    }

    @Test
    @DisplayName("Открытие нескольких символов")
    void test4() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        String guess = "a";
        hangman.word = "aaaa";
        hangman.currentWord = new char[] {'*', '*', '*', '*'};

        // when
        hangman.guessing(guess);

        // then
        assertThat(hangman.currentWord)
            .containsExactly('a', 'a', 'a', 'a');
    }

    @Test
    @DisplayName("Победа")
    void test5() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.unguessed = 0;
        hangman.currentWord = new char[] {'*', '*', '*', '*'};

        // when
        hangman.winOrLost();

        // then
    }

    @Test
    @DisplayName("Поражение")
    void test6() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.unguessed = 1;

        // when
        hangman.winOrLost();

        // then
    }
}
