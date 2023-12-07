package edu.hw9.Task2.Task3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Solver {

    private final static Logger LOGGER = LogManager.getLogger();
    private final char[][] map;
    private final int[][] was;
    public final static char PATH = '^';
    private final int n;
    private final int m;
    public Boolean solved;
    private final BlockingDeque <Dot> stack = new LinkedBlockingDeque<>();

    public Solver(char[][] map) {
        solved = false;
        this.map = map;
        n = map.length;
        m = map[0].length;
        was = new int[n][m];
    }


    public char[][] solve() throws Exception {


        Dot startDot = new Dot(0, 1);
        stack.add(startDot);
        dfs();

        for (int[] i : was) {
            Arrays.fill(i, 0);
        }
        if (!solved) {
            Exception unsolvable = new Exception();
            throw new Exception("Unsolvable puzzle", unsolvable);
        }
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

        try(ExecutorService service = Executors.newFixedThreadPool(8)) {

            while (!solved) {
                service.submit(task1);
            }
        }
    }

    private void dfsWork(Dot cDot){

        was[cDot.i][cDot.j] = 1;

        if (map[cDot.i][cDot.j] == Generator.EXIT || solved) {
            solved = true;
            return;
        }

        map[cDot.i][cDot.j] = PATH;

        List<Dot> possibleMoves = genPossible(cDot);

        for (Dot i : possibleMoves) {
            stack.push(i);
        }


        if (!solved) {
            //map[cDot.i][cDot.j] = Generator.SPACE;
        }
    }

    private record Dot(int i, int j) {
    }
}
