package edu.hw1;

import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private Task6() {
    }

    private final static Logger LOGGER = LogManager.getLogger();
    static private final int DIGITS_IN_COUNT_SYSTEM = 10;
    static private final int KAPREKARS_CONST = 6174;

    public static int getReversed(int number) {
        int n = number;
        int reverse = 0;
        while (n > 0) {
            reverse *= DIGITS_IN_COUNT_SYSTEM;
            reverse += n % DIGITS_IN_COUNT_SYSTEM;
            n /= DIGITS_IN_COUNT_SYSTEM;
        }
        return reverse;
    }

    public static int toInteger(Integer[] v) {
        int integer = 0;
        for (Integer value : v) {
            integer *= DIGITS_IN_COUNT_SYSTEM;
            integer += value;
        }
        return integer;
    }

    public static Integer[] toArray(int n) {
        String str = Integer.toString(n);
        Integer[] digits = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    static private int ans = 0;

    public static int countK(int cin) {

        if (cin == KAPREKARS_CONST) {
            return ans;
        }
        LOGGER.info(cin);

        ans++;

        Integer[] digits = toArray(cin);
        Arrays.sort(digits, Collections.reverseOrder());
        int sorted = toInteger(digits);
        int reversed = getReversed(sorted);
        LOGGER.info("sorted: {}, reversed: {}\n", sorted, reversed);
        countK(sorted - reversed);

        return ans;
    }

    public static int shell(int cin) {
        ans = 0;
        return countK(cin);
    }

}
