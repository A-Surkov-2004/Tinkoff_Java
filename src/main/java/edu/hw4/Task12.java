package edu.hw4;

import java.util.List;

public class Task12 {
    public Integer countFat(List<Animal> animals) {
        return (int) animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }
}
