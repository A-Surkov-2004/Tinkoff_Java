package edu.hw3;

public class Task4 {
    Task4() {
    }

    static private final int M = 1000;
    static private final int D = 500;
    static private final int C = 100;
    static private final int L = 50;
    static private final int X = 10;
    static private final int V = 5;
    static private final int I = 1;

    @SuppressWarnings("MagicNumber")
    String convertToRoman(int sum) {
        int csum = sum;
        StringBuilder ans = new StringBuilder();
        while (csum >= M) {
            ans.append("M");
            csum -= M;
        }
        while (csum >= M - C) {
            ans.append("CM");
            csum -= M - C;
        }
        while (csum >= D) {
            ans.append("D");
            csum -= D;
        }
        while (csum >= D - C) {
            ans.append("CD");
            csum -= D - C;
        }
        while (csum >= C) {
            ans.append("C");
            csum -= C;
        }
        while (csum >= C - X) {
            ans.append("XC");
            csum -= C - X;
        }
        while (csum >= L) {
            ans.append("L");
            csum -= L;
        }
        while (csum >= L - X) {
            ans.append("XL");
            csum -= L - X;
        }
        while (csum >= X) {
            ans.append("X");
            csum -= X;
        }
        while (csum >= X - I) {
            ans.append("IX");
            csum -= X - I;
        }
        while (csum >= V) {
            ans.append("V");
            csum -= V;
        }
        while (csum >= V - I) {
            ans.append("IV");
            csum -= V - I;
        }
        while (csum >= I) {
            ans.append("I");
            csum -= I;
        }
        return ans.toString();
    }
}
