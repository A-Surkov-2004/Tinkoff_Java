package edu.hw6;

import edu.hw6.Task3.Task3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Котики")
    void test1() {
        // given
        Map<String, String> map = new HashMap<>();
        String p = ("src\\main\\java\\edu\\hw6\\Task3\\Files\\");


        // when
        Task3 t3 = new Task3();

        DirectoryStream.Filter<Path> filter = t3.IS_REGULAR_FILE
            .and(t3.IS_READABLE)
            //.and(t3.largerThan(100_000))
            //.and(t3.magicNumber(0x89, 'P', 'N', 'G'))
            //.and(t3.globMatches("*.png"))
            .and(t3.regexContains("cat"));
        List<String> ans = t3.search(p, filter);

        // then
        assertThat(ans)
            .containsExactlyInAnyOrder("src\\main\\java\\edu\\hw6\\Task3\\Files\\167691_cat_24941920.png","src\\main\\java\\edu\\hw6\\Task3\\Files\\cat in pdf.pdf", "src\\main\\java\\edu\\hw6\\Task3\\Files\\cat1.jpeg", "src\\main\\java\\edu\\hw6\\Task3\\Files\\kartinki-nyashnye-kotiki-cat-16.jpg");
    }

    @Test
    @DisplayName("Котики пнг (магические значения)")
    void test2() {
        // given
        Map<String, String> map = new HashMap<>();
        String p = ("src\\main\\java\\edu\\hw6\\Task3\\Files\\");


        // when
        Task3 t3 = new Task3();

        DirectoryStream.Filter<Path> filter = t3.IS_REGULAR_FILE
            .and(t3.IS_READABLE)
            //.and(t3.largerThan(100_000))
            .and(t3.magicNumber(0x89, 'P', 'N', 'G'))
            //.and(t3.globMatches("*.png"))
            .and(t3.regexContains("cat"));
        List<String> ans = t3.search(p, filter);

        // then
        assertThat(ans)
            .containsExactlyInAnyOrder("src\\main\\java\\edu\\hw6\\Task3\\Files\\167691_cat_24941920.png");
    }

    @Test
    @DisplayName("Котики jpg (глоб)")
    void test3() {
        // given
        Map<String, String> map = new HashMap<>();
        String p = ("src\\main\\java\\edu\\hw6\\Task3\\Files\\");


        // when
        Task3 t3 = new Task3();

        DirectoryStream.Filter<Path> filter = t3.IS_REGULAR_FILE
            .and(t3.IS_READABLE)
            //.and(t3.largerThan(100_000))
            //.and(t3.magicNumber(0x89, 'P', 'N', 'G'))
            .and(t3.globMatches("*.jpg"))
            .and(t3.regexContains("cat"));
        List<String> ans = t3.search(p, filter);

        // then
        assertThat(ans)
            .containsExactlyInAnyOrder("src\\main\\java\\edu\\hw6\\Task3\\Files\\kartinki-nyashnye-kotiki-cat-16.jpg");
    }

    @Test
    @DisplayName("все jpeg (глоб)")
    void test4() {
        // given
        Map<String, String> map = new HashMap<>();
        String p = ("src\\main\\java\\edu\\hw6\\Task3\\Files\\");


        // when
        Task3 t3 = new Task3();

        DirectoryStream.Filter<Path> filter = t3.IS_REGULAR_FILE
            .and(t3.IS_READABLE)
            //.and(t3.largerThan(100_000))
            //.and(t3.magicNumber(0x89, 'P', 'N', 'G'))
            .and(t3.globMatches("*.jpeg"));
            //.and(t3.regexContains("cat"));
        List<String> ans = t3.search(p, filter);

        // then
        assertThat(ans)
            .containsExactlyInAnyOrder("src\\main\\java\\edu\\hw6\\Task3\\Files\\cat1.jpeg", "src\\main\\java\\edu\\hw6\\Task3\\Files\\dog_4cdfcb44478dd79dafa81115034d13ea.jpeg");
    }

    @Test
    @DisplayName("Тяжёлые")
    void test5() {
        // given
        Map<String, String> map = new HashMap<>();
        String p = ("src\\main\\java\\edu\\hw6\\Task3\\Files\\");


        // when
        Task3 t3 = new Task3();

        DirectoryStream.Filter<Path> filter = t3.IS_REGULAR_FILE
            //.and(t3.readable)
            .and(t3.largerThan(1_000_000));
            //.and(t3.magicNumber(0x89, 'P', 'N', 'G'))
            //.and(t3.globMatches("*.jpeg"));
        //.and(t3.regexContains("cat"));
        List<String> ans = t3.search(p, filter);

        // then
        assertThat(ans)
            .containsExactlyInAnyOrder("src\\main\\java\\edu\\hw6\\Task3\\Files\\167691_cat_24941920.png", "src\\main\\java\\edu\\hw6\\Task3\\Files\\cat1.jpeg", "src\\main\\java\\edu\\hw6\\Task3\\Files\\dog_4cdfcb44478dd79dafa81115034d13ea.jpeg");
    }
}
