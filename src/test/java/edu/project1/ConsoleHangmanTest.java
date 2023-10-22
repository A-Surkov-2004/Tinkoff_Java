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
        Session session = new Session(5);

        // when
        word = session.getWord();

        // then
        assertThat(word.length())
            .isGreaterThan(0);
    }

    @Test
    @DisplayName("Открытие первого символа")
    void test2() {
        // given
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new ConsoleHangman.Game();
        game.currentSession.word = "abcd";
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
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new ConsoleHangman.Game();
        Session session = new Session(5);
        game.currentSession.word = "abcd";
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
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new ConsoleHangman.Game();
        Session session = new Session(5);
        game.currentSession.word = "dddd";
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
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new ConsoleHangman.Game();
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
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new ConsoleHangman.Game();
        Console console = new Console();
        game.unguessed = 1;

        // when
        console.winOrLost(game.unguessed);

        // then
    }
}
