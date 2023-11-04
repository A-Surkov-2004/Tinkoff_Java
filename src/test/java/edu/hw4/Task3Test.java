package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import edu.hw4.Animal.*;

public class Task3Test {
    @Test
    @DisplayName("Посчитать тип")
    void test1() {
        // given
        Task3 t3 = new Task3();
        Animal a1 = new Animal("Boris", Type.CAT, Sex.M, 5, 25, 4, true);
        Animal a2 = new Animal("Tom", Type.CAT, Sex.M, 5, 23, 5, true);
        Animal a3 = new Animal("Gav", Type.CAT, Sex.M, 1, 19, 2, false);
        Animal a4 = new Animal("Belka", Type.DOG, Sex.F, 3, 30, 4, false);
        Animal a5 = new Animal("Strelka", Type.DOG, Sex.F, 2, 35, 5, false);
        Animal a6 = new Animal("Kesha", Type.BIRD, Sex.M, 1, 19, 1, true);
        List<Animal> given = List.of(a1, a2, a3, a4, a5, a6);
        Map<Type, Long> rans = new HashMap<>();
        rans.put(Type.CAT, 3L);
        rans.put(Type.DOG, 2L);
        rans.put(Type.BIRD, 1L);

        // when
        Map<Type, Long> ans = t3.countType(given);

        // then
        assertThat(ans)
            .isEqualTo(rans);
    }
}
