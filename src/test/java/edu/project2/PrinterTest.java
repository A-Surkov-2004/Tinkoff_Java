package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrinterTest {
    @Test
    @DisplayName("Нерешённый/Решённый")
    void test1() throws Exception {
        // given
        Printer printer = new Printer();

        Generator gen = new Generator(15);
        char [][] map = gen.generate();

        printer.printMap(map);

        Solver s = new Solver();
        char[][] solved = s.solve(map);

        printer.printMap(map);
    }
}
