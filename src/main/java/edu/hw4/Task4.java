package edu.hw4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task4 {
    public Animal longestNameAnimal(List<Animal> animals) {
        return Collections.max(animals, Comparator.comparingInt(animal -> animal.name().length()));
    }
}
