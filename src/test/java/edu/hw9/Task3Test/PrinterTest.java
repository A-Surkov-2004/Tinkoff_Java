package edu.hw9.Task3Test;

import edu.hw9.Task2.Task3.Generator;
import edu.hw9.Task2.Task3.Printer;
import edu.hw9.Task2.Task3.Solver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrinterTest {
    @Test
    @DisplayName("Нерешённый/Решённый")
    void test1() throws Exception {
        // given
        Printer printer = new Printer();

        Generator gen = new Generator(17);
        char [][] map = gen.generate();

        printer.printMap(map);

        Solver s = new Solver(map);
        char[][] solved = s.solve();

        printer.printMap(map);
    }
}
