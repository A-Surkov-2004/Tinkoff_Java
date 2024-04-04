package edu.hw4;

import java.util.List;

public class Task11 {

    private static final int K = 100;

    public List<Animal> bigAndBity(List<Animal> animals) {
        return animals.stream().filter(animal -> animal.bites() && animal.height() > K).toList();
    }
}
