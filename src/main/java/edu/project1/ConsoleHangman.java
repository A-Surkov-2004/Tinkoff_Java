package edu.project1;

import java.util.Arrays;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final static String EXIT_WORD = "pass";
    private final static char BLANK = '*';
    private final static Logger LOGGER = LogManager.getLogger();

    public static class Game {
        int unguessed;
        private final Session currentSession;
        char[] currentWord;
        Console console;

        Game(int maxAttempts, String[] words) {
            currentSession = new Session(maxAttempts, words);
            unguessed = currentSession.getWord().length();
            this.currentWord = new char[currentSession.getWord().length()];
            Arrays.fill(this.currentWord, BLANK);
            console = new Console();
        }

        public boolean guessing(String guess) {
            int lastIndex = 0;
            boolean changed = false;
            while (lastIndex < currentSession.getWord().length() && lastIndex != -1) {
                lastIndex = currentSession.getWord().toLowerCase().indexOf(guess, lastIndex);

                if (lastIndex != -1) {
                    if (this.currentWord[lastIndex] != BLANK) {
                        LOGGER.info("You already guessed it!");
                        lastIndex = -1;
                    } else {
                        this.currentWord[lastIndex] = guess.charAt(0);
                        lastIndex++;
                        this.unguessed--;
                    }
                    changed = true;
                }
            }
            return changed;
        }

        public void run() {
            int attempt = 0;

            while (attempt < currentSession.getMaxAttempts() && unguessed != 0) {
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
                    LOGGER.trace("Missed, mistake {} out of {}", attempt, currentSession.getMaxAttempts());
                }
            }
            console.printCWord(currentWord);
            console.winOrLost(unguessed);
        }
    }

    /* Раскомментить для игры (Run Current File)
    public static void main(String[] args) {
        String[] words = new String[] {"Тинькофф", "Тетриандох", "Аксолотль", "Навохудоноссор"};
        ConsoleHangman.Game game = new Game(5, words);
        game.run();
    }
//*/
}
