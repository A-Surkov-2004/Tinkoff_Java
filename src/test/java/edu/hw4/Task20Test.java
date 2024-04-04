package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task20Test {
    @Test
    @DisplayName("Ошибки")
    void test1() {
        // given
        Task20 t20 = new Task20();
        Animal a1 = new Animal("Sea Okun", Animal.Type.FISH, Animal.Sex.M, 4, 20, -2, true);
        Animal a2 = new Animal("Gorbusha", Animal.Type.FISH, Animal.Sex.F, 3, -50, 2, true);
        Animal a3 = new Animal("Forel", Animal.Type.FISH, Animal.Sex.F, -1, 310, 20, true);
        List<Animal> given = List.of(a1, a2, a3);

        // when
        Map<String, String> ans = t20.runChecks(given);

        // then
        assertThat(ans.get("Forel"))
            .containsSequence("Age");

        assertThat(ans.get("Gorbusha"))
            .containsSequence("Height");

        assertThat(ans.get("Sea Okun"))
            .containsSequence("Weight");
    }
}
