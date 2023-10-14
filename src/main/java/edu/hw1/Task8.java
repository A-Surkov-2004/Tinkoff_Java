package edu.hw1;

@SuppressWarnings("MagicNumber")
public class Task8 {
    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        int size = 8;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    int knights = 0;
                    knights += (i < size - 2 && j < size - 1) ? board[i + 2][j + 1] : 0;
                    knights += (i < size - 1 && j < size - 2) ? board[i + 1][j + 2] : 0;
                    knights += (i < size - 2 && j > 1) ? board[i + 2][j - 1] : 0;
                    knights += (i < size - 1 && j > 2) ? board[i + 1][j - 2] : 0;
                    if (knights != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
