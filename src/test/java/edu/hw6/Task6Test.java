package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Чек портов")
    void test2() throws IOException, URISyntaxException, InterruptedException {
        // given


        // when
        Task6 t6 = new Task6();
        t6.globalCheck();

        // then
        //assertThat(title).isEqualTo("\"JDK 21 Release Notes\"");
    }
}
