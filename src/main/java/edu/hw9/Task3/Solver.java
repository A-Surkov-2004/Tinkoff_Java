package edu.hw9.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Solver {


    public final static char PATH = '^';
    public final static char TRUEPATH = 'V';
    public final static Dot STARTDOT = new Dot(0, 1);
    public Boolean solved;
    private final int n;
    private final int m;
    private final static Logger LOGGER = LogManager.getLogger();
    private final char[][] map;
    private final int[][] was;
    private final Dot[][] father;
    private final BlockingDeque<Dot> stack = new LinkedBlockingDeque<>();
    private Dot exitDot = new Dot(0, 1);

    public Solver(char[][] map) {
        solved = false;
        this.map = map;
        n = map.length;
        m = map[0].length;
        was = new int[n][m];
        father = new Dot[n][m];
    }

    public char[][] solve() {

        for (int[] i : was) {

            Arrays.fill(i, 0);
        }

        stack.add(STARTDOT);

        dfs();

        recolour(exitDot);

        return this.map;
    }

    private void addMove(List<Dot> possibleMoves, Dot mDot) {
        if (mDot.i <= n - 1 && mDot.i >= 0 && mDot.j <= m - 1 && mDot.j >= 0
            && map[mDot.i][mDot.j] != Generator.BLANK && was[mDot.i][mDot.j] == 0) {
            possibleMoves.add(mDot);
        }
    }

    private List<Dot> genPossible(Dot cDot) {

        List<Dot> possibleMoves = new ArrayList<>();

        addMove(possibleMoves, new Dot(cDot.i + 1, cDot.j));
        addMove(possibleMoves, new Dot(cDot.i, cDot.j + 1));
        addMove(possibleMoves, new Dot(cDot.i - 1, cDot.j));
        addMove(possibleMoves, new Dot(cDot.i, cDot.j - 1));

        return possibleMoves;
    }

    private void dfs() {

        Runnable task1 = () -> dfsWork(stack.poll());

        try (ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())) {

            while (!solved) {
                service.submit(task1);
            }
        }
    }

    private void dfsWork(Dot cDot) {

        was[cDot.i][cDot.j] = 1;

        if (map[cDot.i][cDot.j] == Generator.EXIT) {
            exitDot = cDot;
            recolour(cDot);
            solved = true;
        }

        if (solved) {
            return;
        }

        map[cDot.i][cDot.j] = PATH;

        List<Dot> possibleMoves = genPossible(cDot);

        for (Dot i : possibleMoves) {
            stack.push(i);
            father[i.i][i.j] = cDot;
        }

        if (!solved) {
            //map[cDot.i][cDot.j] = Generator.SPACE;
        }
    }

    private synchronized void recolour(Dot cDot) {
        map[cDot.i][cDot.j] = TRUEPATH;
        if (father[cDot.i][cDot.j] != null) {
            recolour(father[cDot.i][cDot.j]);
        }
    }

    private record Dot(int i, int j) {
    }
}
