package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task13Test {
    @Test
    @DisplayName("Сложное имя")
    void test1() {
        // given
        Task13 t13 = new Task13();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Cat named Gav", Type.CAT, Sex.M, 1, 110, 9, true);
        Animal a4 = new Animal("Space dog Belka", Type.DOG, Sex.F, 4, 105, 10, false);
        Animal a5 = new Animal("Spacedog Strelka", Type.DOG, Sex.F, 2, 35, 5, false);
        Animal a6 = new Animal("Kesha the Great", Type.BIRD, Sex.M, 2, 19, 1, true);
        Animal a7 = new Animal("Big Shlepa", Type.CAT, Sex.M, 6, 115, 8, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6, a7);

        // when
        List<Animal> ans = t13.complexName(given);

        // then
        assertThat(ans)
            .isEqualTo(List.of(a3, a4, a6));
    }
}
