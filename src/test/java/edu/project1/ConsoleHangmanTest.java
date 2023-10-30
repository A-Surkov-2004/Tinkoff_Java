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
        String[] words = new String[] {"Тест"};
        Session session = new Session(5, words);

        // when
        word = session.getWord();

        // then
        assertThat(word)
            .isEqualTo("Тест");
    }

    @Test
    @DisplayName("Открытие первого символа")
    void test2() {
        // given
        String[] words = new String[] {"abcd"};
        ConsoleHangman.Game game = new ConsoleHangman.Game(5, words);
        game.currentWord = new char[] {'*', '*', '*', '*'};
        String guess = "a";

        // when
        game.guessing(guess);

        // then
        assertThat(game.currentWord)
            .containsExactly('a', '*', '*', '*');
    }

    @Test
    @DisplayName("Открытие последнего символа")
    void test3() {
        // given
        String[] words = new String[] {"abcd"};
        ConsoleHangman.Game game = new ConsoleHangman.Game(5, words);
        game.currentWord = new char[] {'*', '*', '*', '*'};
        String guess = "d";

        // when
        game.guessing(guess);

        // then
        assertThat(game.currentWord)
            .containsExactly('*', '*', '*', 'd');
    }

    @Test
    @DisplayName("Открытие нескольких символов")
    void test4() {
        // given
        String[] words = new String[] {"dddd"};
        ConsoleHangman.Game game = new ConsoleHangman.Game(5, words);
        game.currentWord = new char[] {'*', '*', '*', '*'};
        String guess = "d";

        // when
        game.guessing(guess);

        // then
        assertThat(game.currentWord)
            .containsExactly('d', 'd', 'd', 'd');
    }

    @Test
    @DisplayName("Победа")
    void test5() {
        // given
        String[] words = new String[] {"abcd"};
        ConsoleHangman.Game game = new ConsoleHangman.Game(0, words);
        Console console = new Console();
        game.unguessed = 0;

        // when
        console.winOrLost(game.unguessed);

        // then
    }

    @Test
    @DisplayName("Поражение")
    void test6() {
        // given
        String[] words = new String[] {"abcd"};
        ConsoleHangman.Game game = new ConsoleHangman.Game(5, words);
        Console console = new Console();
        game.unguessed = 1;

        // when
        console.winOrLost(game.unguessed);

        // then
    }
}
