package edu.hw1;

public class Task2 {

    private Task2() {
    }

    static private final int DIGITS_IN_COUNT_SYSTEM = 10;

    public static int countDigits(int cin) {

        int ans = 1;
        int number = cin;

        while (number / DIGITS_IN_COUNT_SYSTEM != 0) {
            ans++;
            number /= DIGITS_IN_COUNT_SYSTEM;
        }
        return ans;
    }
}
