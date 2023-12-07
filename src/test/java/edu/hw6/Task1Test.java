package edu.hw6;

import edu.hw6.Task1.Diskmap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Соответствие")
    void test1() {
        // given
        Map<String, String> map = new HashMap<>();
        map.put("1", "один");
        map.put("2", "два");
        map.put("3", "три");
        map.put("4", "четыре");
        map.put("5", "пять");

        // when
        Diskmap t1 = new Diskmap(map);
        Map<String, String> ans = t1.loadMap();

        // then
        assertThat(ans)
            .containsEntry("1","один")
            .containsEntry("2","два")
            .containsEntry("3","три")
            .containsEntry("4","четыре")
            .containsEntry("5","пять");
    }
}
