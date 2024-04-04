package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task1Test {
    @Test
    @DisplayName("Имя")
    void test1() {
        // given
        Task1 t1 = new Task1();
        Type cat = Type.CAT;
        Sex m = Sex.M;
        Animal a1 = new Animal("Boris",cat, m, 5, 25,4, true);
        Animal a2 = new Animal("Tom",cat, m, 5, 23,4, true);
        List<Animal> given = List.of(a1, a2);
        // when
        List<Animal> ans = t1.sortHeight(given);

        // then
        assertThat(ans)
            .isEqualTo(List.of(a2, a1));
    }
}
