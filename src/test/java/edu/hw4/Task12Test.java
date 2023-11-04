package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task12Test {
    @Test
    @DisplayName("Лапы не возраст (ауф)")
    void test1() {
        // given
        Task12 t12 = new Task12();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 40, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 50, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 110, 90, true);
        Animal a4 = new Animal("Belka", Type.DOG, Sex.F, 4, 105, 100, false);
        Animal a5 = new Animal("Strelka", Type.DOG, Sex.F, 2, 35, 50, false);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 10, true);
        Animal a7 = new Animal("Shlepa", Type.CAT, Sex.M, 6, 115, 80, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6, a7);

        // when
        Integer ans = t12.countFat(given);

        // then
        assertThat(ans)
            .isEqualTo(3);
    }
}
