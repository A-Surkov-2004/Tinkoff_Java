package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task10Test {
    @Test
    @DisplayName("Лапы не возраст (ауф)")
    void test1() {
        // given
        Task10 t10 = new Task10();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 19, 2, false);
        Animal a4 = new Animal("Belka", Type.DOG, Sex.F, 4, 30, 4, false);
        Animal a5 = new Animal("Strelka", Type.DOG, Sex.F, 2, 35, 5, false);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 1, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6);

        // when
        List<Animal> ans = t10.ageIsNotPaws(given);

        // then
        assertThat(ans)
            .isEqualTo(List.of(a2,a3,a5));
    }
}
