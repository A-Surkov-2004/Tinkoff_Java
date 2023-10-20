package edu.hw1;

public class Task4 {

    private Task4() {
    }

    public static String fixString(String str) {
        char mem;
        char[] v = str.toCharArray();
        for (int i = 0; i < v.length - v.length % 2; i += 2) {
            mem = v[i];
            v[i] = v[i + 1];
            v[i + 1] = mem;
        }
        return new String(v);
    }
}
