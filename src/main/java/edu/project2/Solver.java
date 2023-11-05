package edu.project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solver {

    private char[][] map;
    private int[][] was;
    public final static char PATH = '^';
    private int n;
    private int m;
    Boolean solved = false;

    Solver() {

    }

    List<Dot> addMove(List<Dot> possibleMoves, Dot mDot) {
        if (mDot.i <= n - 1 && mDot.i >= 0 && mDot.j <= m - 1 && mDot.j >= 0
            && map[mDot.i][mDot.j] != Generator.BLANK && was[mDot.i][mDot.j] == 0) {
            possibleMoves.add(mDot);
        }
        return possibleMoves;
    }

    List<Dot> genPossible(Dot cDot) {

        List<Dot> possibleMoves = new ArrayList<>();

        possibleMoves = addMove(possibleMoves, new Dot(cDot.i + 1, cDot.j));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i, cDot.j + 1));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i - 1, cDot.j));
        possibleMoves = addMove(possibleMoves, new Dot(cDot.i, cDot.j - 1));

        return possibleMoves;
    }

    void dfs(Stack<Dot> stack) {

        Dot cDot = stack.peek();
        was[cDot.i][cDot.j] = 1;

        if (map[cDot.i][cDot.j] == Generator.EXIT || solved) {
            solved = true;
            return;
        }

        map[cDot.i][cDot.j] = PATH;

        List<Dot> possibleMoves = genPossible(cDot);

        while (!possibleMoves.isEmpty()) {
            int chosen = (int) (Math.random() * possibleMoves.size());
            stack.add(possibleMoves.get(chosen));
            dfs(stack);
            possibleMoves = genPossible(cDot);
        }

        if (!solved) {
            map[cDot.i][cDot.j] = Generator.SPACE;
        }

        stack.pop();
    }

    char[][] solve(char[][] map) throws Exception {

        Exception unsolvable = new Exception();

        this.map = map;
        n = map.length;
        m = map[0].length;
        was = new int[n][m];

        Stack<Dot> stack = new Stack<>();
        Dot startDot = new Dot(0, 1);
        stack.add(startDot);
        dfs(stack);

        for (int[] i : was) {
            Arrays.fill(i, 0);
        }
        if (!solved) {
            throw new Exception("Unsolvable puzzle", unsolvable);
        }
        return this.map;
    }

    private record Dot(int i, int j) {
    }
}
