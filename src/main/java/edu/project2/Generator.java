package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Generator {

    private final int n;
    private final int m;
    public final static char BLANK = '#';
    public final static char EXIT = 'E';
    public final static char SPACE = ' ';
    private char[][] map;

    private boolean haveExit = false;

    public Generator(int n) {
        this.n = n * 2 + 1;
        this.m = n * 2 + 1;
    }

    public char[][] generate() {
        map = new char[m][n];
        for (char[] i : map) {
            Arrays.fill(i, BLANK);
        }

        map[0][1] = Solver.PATH;

        Deque<Dot> stack = new ArrayDeque<>();
        dfs(stack);

        if (!haveExit) {
            map[n - 1][m - 2] = SPACE;
        }

        return map;
    }

    private void addMove(List<Dot> possibleMoves, Dot mDot) {
        if (mDot.i < n - 1 && mDot.i > 0 && mDot.j < m - 1 && mDot.j > 0 && map[mDot.i][mDot.j] == BLANK) {
            possibleMoves.add(mDot);
        }
    }

    private List<Dot> genPossible(Dot cDot) {

        List<Dot> possibleMoves = new ArrayList<>();

        addMove(possibleMoves, new Dot(cDot.i + 2, cDot.j));
        addMove(possibleMoves, new Dot(cDot.i, cDot.j + 2));
        addMove(possibleMoves, new Dot(cDot.i - 2, cDot.j));
        addMove(possibleMoves, new Dot(cDot.i, cDot.j - 2));

        return possibleMoves;
    }

    private void placeExit(Dot mDot) {
        if (!haveExit && (mDot.i == n - 1 || mDot.i == 0 || mDot.j == m - 1 || mDot.j == 0)) {
            map[mDot.i][mDot.j] = EXIT;
            haveExit = true;
        }
    }

    private void dfs(Deque<Dot> stack) {

        Dot last = new Dot(1, 1);
        stack.add(last);

        while (!stack.isEmpty()) {

            Dot cDot = stack.peek();
            map[cDot.i][cDot.j] = SPACE;
            map[cDot.i - (cDot.i - last.i) / 2][cDot.j - (cDot.j - last.j) / 2] = SPACE;

            List<Dot> possibleMoves = genPossible(cDot);

            if (!possibleMoves.isEmpty()) {
                int chosen = (int) (Math.random() * possibleMoves.size());
                stack.push(possibleMoves.get(chosen));
            }

            if (possibleMoves.isEmpty()) {
                stack.pop();
                if (!haveExit) {
                    placeExit(new Dot(cDot.i + 1, cDot.j));
                    placeExit(new Dot(cDot.i - 1, cDot.j));
                    placeExit(new Dot(cDot.i, cDot.j + 1));
                    placeExit(new Dot(cDot.i, cDot.j - 1));
                }
            }
            last = cDot;
        }
    }

    private record Dot(int i, int j) {
    }
}
