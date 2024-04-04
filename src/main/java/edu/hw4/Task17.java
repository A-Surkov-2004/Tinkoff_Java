package edu.hw4;

import java.util.List;

public class Task17 {
    public boolean bitingSpiders(List<Animal> animals) {
        long spiders =
            animals.stream().filter(Animal::bites).filter(animal -> animal.type() == Animal.Type.SPIDER).count();
        long dogs =
            animals.stream().filter(Animal::bites).filter(animal -> animal.type() == Animal.Type.DOG).count();
        if (dogs == 0) {
            return false;
        }
        return spiders > dogs;
    }
}
