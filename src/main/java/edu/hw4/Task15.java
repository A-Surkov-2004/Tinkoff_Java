package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    public Map<Animal.Type, Integer> sumWeight(List<Animal> animals, int k, int i) {
        return animals.stream().filter(animal -> animal.age() >= k && animal.age() <= i)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }
}
