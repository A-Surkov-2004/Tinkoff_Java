package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

    Comparator<Animal> compareByWeight = Comparator
        .comparing(Animal::getWeight)
        .reversed();

    public List<Animal> sortWeight(List<Animal> animals, int k) {
        List<Animal> sorted = animals.stream()
            .sorted(compareByWeight)
            .collect(Collectors.toCollection(ArrayList::new));
        List<Animal> ans = new ArrayList<>();
        for (int i = 0; i < k && i < sorted.size(); i++) {
            ans.add(sorted.get(i));
        }
        return ans;
    }

}
