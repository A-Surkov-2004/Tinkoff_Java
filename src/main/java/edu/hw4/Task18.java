package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Task18 {
    public Animal massiveFish(List<List<Animal>> animals) {
        Stream<Animal> stream = animals.get(0).stream();
        for (List<Animal> i : animals) {
            stream = Stream.concat(stream, i.stream());
        }
        return stream.filter(animal -> animal.type() == Animal.Type.FISH).max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
