package edu.hw1;

import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class Task6 {
    private Task6() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    @SuppressWarnings("ParameterAssignment")
    public static int getReversed(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }

    public static int toInteger(Integer[] v) {
        int integer = 0;
        for (int i = 0; i < v.length; i++) {
            integer *= 10;
            integer += v[i];
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

        if (cin == 6174) {
            return ans;
        }
        LOGGER.info(cin);

        ans++;

        Integer[] digits = toArray(cin);
        Arrays.sort(digits, Collections.reverseOrder());
        int sorted = toInteger(digits);
        int reversed = getReversed(sorted);
        LOGGER.info(sorted);
        LOGGER.info(reversed);
        LOGGER.info('\n');
        countK(sorted - reversed);

        return ans;
    }

    public static int shell(int cin) {
        ans = 0;
        return countK(cin);
    }

}
