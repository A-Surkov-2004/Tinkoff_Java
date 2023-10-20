package edu.project1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private final static int MAX_ATTEMPTS = 5;
    private final static String EXIT_WORD = "pass";
    public String word;
    public char[] currentWord;
    public int unguessed;
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Scanner IN = new Scanner(System.in);

    public String getWord() {
        String[] words = new String[] {"Тинькофф", "Тетриандох", "Аксолотль", "Навохудоноссор"};
        //String[] words = new String[] {"Навохудоноссор"};
        return words[(int) (Math.random() * words.length)];
    }

    public boolean guessing(String guess) {
        int lastIndex = 0;
        boolean changed = false;
        while (lastIndex < this.word.length()) {
            lastIndex = this.word.toLowerCase().indexOf(guess, lastIndex);

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

    public void printCWord() {
        StringBuilder printWord = new StringBuilder();
        for (char i : this.currentWord) {
            printWord.append(i);
        }
        LOGGER.info("The word: " + printWord);
    }

    private String getGuess() {
        String guess = "";
        LOGGER.info("Guess a letter: (or '" + EXIT_WORD + "' to end suffering)");
        while (guess.length() != 1) {
            guess = IN.nextLine();
            if (Objects.equals(guess, EXIT_WORD)) {
                return guess;
            }
            if (guess.length() != 1) {
                LOGGER.info("Incorrect input, try again");
            }
        }
        return guess;
    }

    public void winOrLost() {
        if (this.unguessed == 0) {
            printCWord();
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }

    public void run() {
        this.word = getWord();
        this.currentWord = new char[word.length()];
        Arrays.fill(this.currentWord, '*');
        unguessed = word.length();
        int attempt = 0;

        while (attempt < MAX_ATTEMPTS && unguessed != 0) {
            printCWord();
            String guess = getGuess();
            if (Objects.equals(guess, EXIT_WORD)) {
                break;
            }

            boolean changed = guessing(guess);

            if (changed) {
                LOGGER.info("Hit!");
            } else {
                attempt++;
                LOGGER.info("Missed, mistake " + attempt + " out of " + MAX_ATTEMPTS);
            }
        }
        winOrLost();
    }

    /*      Раскомментить для игры (Run Current File)
    public static void main(String[] args) {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.run();
    }
    */
}
