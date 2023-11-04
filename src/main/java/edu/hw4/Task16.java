package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task16 {

    Comparator<Animal> compareByWeight = Comparator
        .comparing(Animal::type)
        .thenComparing(Animal::sex)
        .thenComparing(Animal::name);

    public List<Animal> sortTypeSexName(List<Animal> animals) {
        List<Animal> sorted = animals.stream()
            .sorted(compareByWeight)
            .collect(Collectors.toCollection(ArrayList::new));
        return sorted;
    }
}
