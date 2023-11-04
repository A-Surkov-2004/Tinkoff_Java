package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import edu.hw4.Animal.*;

public class Task17Test {
    @Test
    @DisplayName("true")
    void test1() {
        // given
        Task17 t17 = new Task17();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 110, 9, true);
        Animal a4 = new Animal("Belka", Type.DOG, Sex.F, 4, 105, 10, true);
        Animal a5 = new Animal("Strelka", Type.DOG, Sex.F, 2, 35, 5, true);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 1, true);
        Animal a7 = new Animal("Shlepa", Type.CAT, Sex.M, 6, 115, 8, true);
        Animal a8 = new Animal("Shnuk", Type.SPIDER, Sex.M, 25, 2, 0, true);
        Animal a9 = new Animal("Jukessa", Type.SPIDER, Sex.F, 5, 1, 0, true);
        Animal a10 = new Animal("Cherep", Type.SPIDER, Sex.M, 15, 10, 1, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);

        // when
        boolean ans = t17.bitingSpiders(given);

        // then
        assertThat(ans)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("false")
    void test2() {
        // given
        Task17 t17 = new Task17();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 110, 9, true);
        Animal a4 = new Animal("Belka", Type.DOG, Sex.F, 4, 105, 10, true);
        Animal a5 = new Animal("Strelka", Type.DOG, Sex.F, 2, 35, 5, true);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 1, true);
        Animal a7 = new Animal("Shlepa", Type.CAT, Sex.M, 6, 115, 8, true);
        Animal a8 = new Animal("Shnuk", Type.SPIDER, Sex.M, 25, 2, 0, false);
        Animal a9 = new Animal("Jukessa", Type.SPIDER, Sex.F, 5, 1, 0, false);
        Animal a10 = new Animal("Cherep", Type.SPIDER, Sex.M, 15, 10, 1, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);

        // when
        boolean ans = t17.bitingSpiders(given);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Нет собак и пауков")
    void test3() {
        // given
        Task17 t17 = new Task17();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 110, 9, true);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 1, true);
        Animal a7 = new Animal("Shlepa", Type.CAT, Sex.M, 6, 115, 8, true);
        List<Animal> given = List.of(a1, a2, a3, a6, a7);

        // when
        boolean ans = t17.bitingSpiders(given);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Нет собак")
    void test4() {
        // given
        Task17 t17 = new Task17();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 4, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 6, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 110, 9, true);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 2, 19, 1, true);
        Animal a7 = new Animal("Shlepa", Type.CAT, Sex.M, 6, 115, 8, true);
        Animal a8 = new Animal("Shnuk", Type.SPIDER, Sex.M, 25, 2, 0, false);
        Animal a9 = new Animal("Jukessa", Type.SPIDER, Sex.F, 5, 1, 0, false);
        Animal a10 = new Animal("Cherep", Type.SPIDER, Sex.M, 15, 10, 1, true);
        List<Animal> given = List.of(a1, a2, a3, a6, a7, a8, a9, a10);


        // when
        boolean ans = t17.bitingSpiders(given);

        // then
        assertThat(ans)
            .isEqualTo(false);
    }
}
