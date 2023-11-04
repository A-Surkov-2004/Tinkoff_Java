package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task19Test {
    @Test
    @DisplayName("Ошибки")
    void test1() {
        // given
        Task19 t19 = new Task19();
        Animal a1 = new Animal("Sea Okun", Animal.Type.FISH, Animal.Sex.M, 4, 20, -2, true);
        Animal a2 = new Animal("Gorbusha", Animal.Type.FISH, Animal.Sex.F, 3, -50, 2, true);
        Animal a3 = new Animal("Forel", Animal.Type.FISH, Animal.Sex.F, -1, 310, 20, true);
        List<Animal> given = List.of(a1, a2, a3);

        // when
        Map<String, Set<Task19.ValidationError>> ans = t19.runChecks(given);

        // then
        assertThat(ans.get("Forel"))
            .first().getClass()
            .equals(Task19.AgeVal.class);

        assertThat(ans.get("Gorbusha"))
            .first().getClass()
            .equals(Task19.HeightVal.class);

        assertThat(ans.get("Sea Okun"))
            .first().getClass()
            .equals(Task19.WeightVal.class);
    }
}
