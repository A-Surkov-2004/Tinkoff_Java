package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Generator {

    private final int n;
    private final int m;
    public final static char BLANK = '#';
    public final static char EXIT = 'E';
    public final static char SPACE = ' ';
    private char[][] map;

    private boolean haveExit = false;

    Generator(int n) {
        this.n = n * 2 + 1;
        this.m = n * 2 + 1;
    }

    List<Dot> addMove(List<Dot> possibleMoves, Dot mDot) {
        if (mDot.i < n - 1 && mDot.i > 0 && mDot.j < m - 1 && mDot.j > 0 && map[mDot.i][mDot.j] == BLANK) {
            possibleMoves.add(mDot);
        }
        return possibleMoves;
    }

    List<Dot> genPossible(Dot cDot) {

        List<Dot> possibleMoves = new ArrayList<>();

        possibleMoves = addMove(possibleMoves, new Dot(cDot.i + 2, cDot.j));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i, cDot.j + 2));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i - 2, cDot.j));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i, cDot.j - 2));

        return possibleMoves;
    }

    void placeExit(Dot mDot) {
        if (!haveExit && (mDot.i == n - 1 || mDot.i == 0 || mDot.j == m - 1 || mDot.j == 0)) {
            map[mDot.i][mDot.j] = EXIT;
            haveExit = true;
        }
    }

    void dfs(Stack<Dot> stack, Dot last) {

        if (stack.isEmpty()) {
            return;
        }

        Dot cDot = stack.peek();
        map[cDot.i][cDot.j] = SPACE;
        map[cDot.i - (cDot.i - last.i) / 2][cDot.j - (cDot.j - last.j) / 2] = SPACE;

        List<Dot> possibleMoves = genPossible(cDot);

        while (!possibleMoves.isEmpty()) {
            int chosen = (int) (Math.random() * possibleMoves.size());
            stack.add(possibleMoves.get(chosen));
            dfs(stack, cDot);
            possibleMoves = genPossible(cDot);
        }

        stack.pop();
        //*
        if (!haveExit) {
            placeExit(new Dot(cDot.i + 1, cDot.j));
            placeExit(new Dot(cDot.i - 1, cDot.j));
            placeExit(new Dot(cDot.i, cDot.j + 1));
            placeExit(new Dot(cDot.i, cDot.j - 1));
        }
        //*/
    }

    char[][] generate() {
        map = new char[m][n];
        for (char[] i : map) {
            Arrays.fill(i, BLANK);
        }

        map[0][1] = Solver.PATH;

        Stack<Dot> stack = new Stack<>();
        Dot startDot = new Dot(1, 1);
        stack.add(startDot);
        dfs(stack, startDot);

        if (!haveExit) {
            map[n - 1][m - 2] = SPACE;
        }

        return map;
    }

    private record Dot(int i, int j) {
    }

        /* Раскомментить для игры (Run Current File)
    public static void main(String[] args) throws Exception {

        Printer printer = new Printer();

        Generator gen = new Generator(1);
        char [][] map = gen.generate();

        printer.printMap(map);

        Solver s = new Solver();
        char[][] solved = s.solve(map);

        printer.printMap(map);
    }
//*/
}
