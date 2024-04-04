package edu.hw4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task6 {
    public Map<Animal.Type, Animal> mostMassivePerSpecie(List<Animal> animals) {

        Map<Animal.Type, Animal> ans = new HashMap<>();
        Map<Animal.Type, Optional<Animal>> ansOpt;

        ansOpt = animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(Comparator.comparing(
            animal -> animal.weight()))));

        for (Animal.Type i : ansOpt.keySet()) {
            ans.put(i, ansOpt.get(i).orElse(null));
        }

        return ans;

    }
}
