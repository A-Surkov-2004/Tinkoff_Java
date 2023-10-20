package edu.hw1;

public class Task8 {
    private Task8() {
    }

    static private final int BOARD_SIZE = 8;

    public static boolean knightBoardCapture(int[][] board) {

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == 1) {
                    int knights = 0;
                    knights += (i < BOARD_SIZE - 2 && j < BOARD_SIZE - 1) ? board[i + 2][j + 1] : 0;
                    knights += (i < BOARD_SIZE - 1 && j < BOARD_SIZE - 2) ? board[i + 1][j + 2] : 0;
                    knights += (i < BOARD_SIZE - 2 && j > 1) ? board[i + 2][j - 1] : 0;
                    knights += (i < BOARD_SIZE - 1 && j > 2) ? board[i + 1][j - 2] : 0;
                    if (knights != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
