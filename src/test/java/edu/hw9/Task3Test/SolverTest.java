package edu.hw9.Task3Test;

import edu.hw9.Task3.Generator;
import edu.hw9.Task3.Solver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolverTest {
    @Test
    @DisplayName("Стресс тест 1")
    void test1() throws Exception {
        for (int i = 0; i < 1000; i++){

            // given
            Generator gen = new Generator(15);

            //when
            char [][] map = gen.generate();
            Solver s = new Solver(map);
            char[][] solved = s.solve();

            // then
            assertThat(s.solved)
                .isEqualTo(true);
        }
    }

    @Test
    @DisplayName("Стресс тест 2, разные размеры")
    void test2() throws Exception {
        for (int i = 1; i < 100; i++){


            // given
            Generator gen = new Generator(i);

            //when
            char [][] map = gen.generate();
            Solver s = new Solver(map);
            char[][] solved = s.solve();

            // then
            assertThat(s.solved)
                .isEqualTo(true);
        }
    }

    @Test
    @DisplayName("Лабиринт 1х1")
    void test3() throws Exception {
        // given
        Generator gen = new Generator(1);

        //when
        char [][] map = gen.generate();
        Solver s = new Solver(map);
        char[][] solved = s.solve();

        // then
        assertThat(s.solved)
            .isEqualTo(true);
    }
}
