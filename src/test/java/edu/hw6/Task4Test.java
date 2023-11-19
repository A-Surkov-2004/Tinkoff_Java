package edu.hw6;

import edu.hw6.Task3.Task3;
import edu.hw6.Task4.Task4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Перезапись")
    void test5() throws IOException {
        // given
        Map<String, String> map = new HashMap<>();
        Path p = Path.of("src\\main\\java\\edu\\hw6\\Task4\\Files\\newFile1.txt");


        // when
        Task4 t4 = new Task4();

        t4.writeInFile(p, "Tinkoff");

        // then
    }
}
