package edu.hw4;

import java.util.List;

public class Task14 {
    public boolean bigDog(List<Animal> animals, int k) {
        return animals.stream().anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }
}
