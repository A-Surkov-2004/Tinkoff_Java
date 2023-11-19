package edu.hw6;

import edu.hw6.Task1.Diskmap;
import edu.hw6.Task2.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Начало")
    void test1() {
        // given
        Map<String, String> map = new HashMap<>();
        Path p = Path.of("src\\main\\java\\edu\\hw6\\Task2\\Tinkoff Bank Biggest Secret.txt");


        // when
        Task2 t2 = new Task2();
        t2.makeCopy(p);

        // then
        //assertThat(ans)
    }
}
