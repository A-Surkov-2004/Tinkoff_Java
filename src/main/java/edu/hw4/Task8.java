package edu.hw4;

import java.util.Comparator;
import java.util.List;

public class Task8 {
    public Animal mostMassiveLowerK(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k).max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }
}
