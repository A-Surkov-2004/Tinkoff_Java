package edu.hw4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import edu.hw4.Animal.*;

public class Task18Test {
    @Test
    @DisplayName("Тяжёлая Рыбка")
    void test1() {
        // given
        Task18 t18 = new Task18();
        Animal a1 = new Animal("Sea Okun", Type.FISH, Sex.M, 4, 20, 2, true);
        Animal a2 = new Animal("Gorbusha", Type.FISH, Sex.F, 3, 50, 2, true);
        Animal a3 = new Animal("Forel", Type.FISH, Sex.F, 6, 310, 20, true);

        Animal a6 = new Animal("Shuka", Type.FISH, Sex.F, 5, 100, 8, true);
        Animal a7 = new Animal("Shlakoblokun", Type.FISH, Sex.M, 6, 390, 28, true);
        Animal a8 = new Animal("Losos", Type.FISH, Sex.M, 4, 300, 18, true);
        List<Animal> l1 = List.of(a1, a2, a3);
        List<Animal> l2 = List.of(a6, a7, a8);
        List<List<Animal>> given = new ArrayList<>();
        given.add(l1);
        given.add(l2);

        // when
        Animal ans = t18.massiveFish(given);

        // then
        assertThat(ans)
            .isEqualTo(a7);
    }
}
