package edu.hw1;

public class Task2 {

    private Task2() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countDigits(int cin) {

        int ans = 1;
        int number = cin;

        while (number / 10 != 0) {
            ans++;
            number /= 10;
        }
        return ans;
    }
}
