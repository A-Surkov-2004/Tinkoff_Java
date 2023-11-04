package edu.hw4;

import java.util.List;

public class Task10 {
    public List<Animal> ageIsNotPaws(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }
}
