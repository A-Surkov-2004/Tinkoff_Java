package edu.hw4;

import java.util.List;

public class Task5 {
    public Animal.Sex countSex(List<Animal> animals) {
        int s = (int) animals.stream().filter(a -> a.sex() == Animal.Sex.M).count();
        if (s > animals.size() / 2) {
            return Animal.Sex.M;
        } else if (s < animals.size() / 2) {
            return Animal.Sex.F;
        }
        return null;
    }

}
