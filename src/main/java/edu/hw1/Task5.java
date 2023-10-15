package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {
    private Task5() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    static private final int DIGITS_IN_COUNT_SYSTEM = 10;


    public static boolean isPalindromeDescendant(int cin) {
        String str = Integer.toString(cin);
        boolean ok = true;

        if (str.length() == 1) {
            return false;
        }

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                ok = false;
                break;
            }
        }
        if (ok) {
            return true;
        } else {
            int number = 0;
            for (int i = 0; i < str.length(); i += 2) {

                int digit = 0;
                digit += str.charAt(i) - '0';
                digit += str.charAt(i + 1) - '0';
                number *= (int) Math.pow(DIGITS_IN_COUNT_SYSTEM, (digit / DIGITS_IN_COUNT_SYSTEM + 1));
                number += digit;
            }
            LOGGER.info(number);
            return isPalindromeDescendant(number);
        }
    }
}
