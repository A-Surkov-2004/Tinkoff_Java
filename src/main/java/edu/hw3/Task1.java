package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    Task1() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public String atbash(String str) {
        StringBuilder printWord = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ('z' - ch + 'a');
            } else if ((ch >= 'A' && ch <= 'Z')) {
                ch = (char) ('Z' - ch + 'A');
            }
            printWord.append(ch);
        }
        return printWord.toString();
    }

}
