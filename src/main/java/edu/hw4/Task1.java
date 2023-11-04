package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {

    Comparator<Animal> compareByHeight = Comparator
        .comparing(Animal::getHeight);

    public List<Animal> sortHeight(List<Animal> animals) {
        List<Animal> ans = animals.stream()
            .sorted(compareByHeight)
            .collect(Collectors.toCollection(ArrayList::new));
        //animals.sort((o2, o1) -> o1.getHeight().compareTo(o2.getHeight()));
        return ans;
    }
}
