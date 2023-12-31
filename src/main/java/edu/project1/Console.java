package edu.project1;

import java.util.Objects;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Console {
    private final static String EXIT_WORD = "pass";
    private final static Logger LOGGER = LogManager.getLogger();
    private final static Scanner IN = new Scanner(System.in);

    Console() {
    }

    public void printCWord(char[] currentWord) {
        StringBuilder printWord = new StringBuilder();
        for (char i : currentWord) {
            printWord.append(i);
        }
        LOGGER.trace("The word: {}", printWord);
    }

    String getGuess() {
        String guess = "";
        LOGGER.trace("Guess a letter: (or '{}' to end suffering)", EXIT_WORD);
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

    public void winOrLost(int unguessed) {
        if (unguessed == 0) {
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }
}
