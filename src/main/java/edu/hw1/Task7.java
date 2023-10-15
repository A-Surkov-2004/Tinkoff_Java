package edu.hw1;

public class Task7 {
    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int shiftLeft = shift;
        int size = Integer.toBinaryString(n).length();
        shiftLeft = shiftLeft % size;
        int transfer = (n >> (size - shiftLeft));
        int remains = (int) ((n << shiftLeft) % (Math.pow(2, size)));
        return remains + transfer;
    }

    public static int rotateRight(int n, int shift) {
        int shiftLeft = shift;
        int size = Integer.toBinaryString(n).length();
        shiftLeft = shiftLeft % size;
        int transfer = (int) (n % Math.pow(2, shiftLeft));
        int remains = (n >> shiftLeft);
        int ans = (int) (remains + transfer * Math.pow(2, size - shiftLeft));
        return ans;
    }
}
