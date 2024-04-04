package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task7 {
    public Animal oldestAnimal(List<Animal> animals) {
        return Collections.max(animals, Comparator.comparingInt(Animal::age));
    }
}
