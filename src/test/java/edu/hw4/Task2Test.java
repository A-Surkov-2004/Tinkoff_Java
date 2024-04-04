package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task2Test {
    @Test
    @DisplayName("Вес")
    void test1() {
        // given
        Task2 t2 = new Task2();
        Type cat = Type.CAT;
        Animal a1 = new Animal("Boris",cat, Sex.M, 5, 25,4, true);
        Animal a2 = new Animal("Tom",cat, Sex.M, 5, 23,5, true);
        Animal a3 = new Animal("Gav",cat, Sex.M, 1, 19,2, false);
        List<Animal> given = List.of(a1, a2, a3);
        int k = 2;
        // when
        List<Animal> ans = t2.sortWeight(given, k);

        // then
        assertThat(ans)
            .isEqualTo(List.of(a2, a1));
    }
}
