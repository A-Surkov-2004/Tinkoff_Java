package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Список")
    void test1() throws IOException, URISyntaxException, InterruptedException {
        // given


        // when
        HackerNews t5 = new HackerNews();

        t5.hackerNewsTopStories();

        // then
    }

    @Test
    @DisplayName("Название")
    void test2() throws IOException, URISyntaxException, InterruptedException {
        // given


        // when
        HackerNews t5 = new HackerNews();

        String title = t5.news(37570037);

        // then
        assertThat(title).isEqualTo("\"JDK 21 Release Notes\"");
    }

    @Test
    @DisplayName("Первое название")
    void test3() throws IOException, URISyntaxException, InterruptedException {
        // given
        HackerNews t5 = new HackerNews();
        long l = t5.hackerNewsTopStories()[0];

        // when

        String title = t5.news(l);

        // then
        //assertThat(title).isEqualTo("\"JDK 21 Release Notes\"");
    }
}
