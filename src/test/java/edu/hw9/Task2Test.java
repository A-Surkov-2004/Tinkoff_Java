package edu.hw9;

import edu.hw9.Task2.Task2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Task2Test {
    private final static Logger LOGGER = LogManager.getLogger();
    @Test
    void test1() {
        Task2 t2 = new Task2();

        Path p = Path.of("src","main","java", "edu", "hw9", "Task2", "Tree");

        List<Path> ans = t2.filesMoreThenN(p, 1000);

        LOGGER.trace(ans);
    }

    @Test
    void test2() {
        Task2 t2 = new Task2();

        Path p = Path.of("src","main","java", "edu", "hw9", "Task2", "Tree");

        List<Path> ans = t2.findGlob(p, "*.txt");

        LOGGER.trace(ans);
    }
}
