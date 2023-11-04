package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public Map<Animal.Type, Long> countType(List<Animal> animals) {
        Stream<Animal> stream = animals.stream();
        Map<Animal.Type, Long> ans = stream.collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
        return ans;
    }
}
