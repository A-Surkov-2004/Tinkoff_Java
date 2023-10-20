package edu.hw1;

public class Task3 {
    private Task3() {
    }

    static private int[] minMax(int[] v) {
        int minv = v[0];
        int maxv = v[0];

        for (int i : v) {
            if (i < minv) {
                minv = i;
            }
            if (i > maxv) {
                maxv = i;
            }
        }
        return (new int[] {minv, maxv});
    }

    public static boolean isNestable(int[] a, int[] b) {

        int[] amm = minMax(a);
        int[] bmm = minMax(b);

        return amm[0] > bmm[0] && amm[1] < bmm[1];
    }
}
