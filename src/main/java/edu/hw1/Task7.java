package edu.hw1;

@SuppressWarnings("ParameterAssignment")
public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int size = Integer.toBinaryString(n).length();
        shift = shift % size;
        int transfer = (n >> (size - shift));
        int remains = (int) ((n << shift) % (Math.pow(2, size)));
        int ans = remains + transfer;
        return ans;
    }

    public static int rotateRight(int n, int shift) {
        int size = Integer.toBinaryString(n).length();
        shift = shift % size;
        int transfer = (int) (n % Math.pow(2, shift));
        int remains = (n >> shift);
        int ans = (int) (remains + transfer * Math.pow(2, size - shift));
        return ans;
    }
}
