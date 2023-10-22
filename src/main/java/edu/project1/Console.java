package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

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
        LOGGER.info("The word: " + printWord);
    }

    String getGuess() {
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

    public void winOrLost(int unguessed) {
        if (unguessed == 0) {
            LOGGER.info("You won!");
        } else {
            LOGGER.info("You lost!");
        }
    }
}
