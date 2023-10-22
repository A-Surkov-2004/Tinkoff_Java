package edu.project1;

import java.util.Arrays;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final static String EXIT_WORD = "pass";
    private final static Logger LOGGER = LogManager.getLogger();

    public static class Game {
        int unguessed;
        Session CurrentSession;
        public char[] currentWord;
        Console console;

        Game() {
            CurrentSession = new Session(5);
            unguessed = CurrentSession.word.length();
            this.currentWord = new char[CurrentSession.word.length()];
            Arrays.fill(this.currentWord, '*');
            console = new Console();
        }

        public boolean guessing(String guess) {
            int lastIndex = 0;
            boolean changed = false;
            while (lastIndex < CurrentSession.word.length()) {
                lastIndex = CurrentSession.word.toLowerCase().indexOf(guess, lastIndex);

                if (lastIndex == -1) {
                    break;
                } else if (this.currentWord[lastIndex] != '*') {
                    LOGGER.info("You already guessed it!");
                    changed = true;
                    break;
                }
                this.currentWord[lastIndex] = guess.charAt(0);
                lastIndex++;
                this.unguessed--;
                changed = true;
            }
            return changed;
        }

        public void run() {
            int attempt = 0;

            while (attempt < CurrentSession.maxAttempts && unguessed != 0) {
                console.printCWord(currentWord);
                String guess = console.getGuess();
                if (Objects.equals(guess, EXIT_WORD)) {
                    break;
                }

                boolean changed = guessing(guess);

                if (changed) {
                    LOGGER.info("Hit!");
                } else {
                    attempt++;
                    LOGGER.info("Missed, mistake " + attempt + " out of " + CurrentSession.maxAttempts);
                }
            }
            console.printCWord(currentWord);
            console.winOrLost(unguessed);
        }
    }

 /* Раскомментить для игры (Run Current File)
    public static void main(String[] args) {
        ConsoleHangman hangman = new ConsoleHangman();
        ConsoleHangman.Game game = new Game();
        game.run();
    }
*/
}
