package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task19 {

    private static final int MAX_NAME_LEN = 30;

    Set<ValidationError> makeSet(Animal animal) {
        Set<ValidationError> set = new HashSet<>();

        NameVal nv = new NameVal(animal);
        if (!nv.validations.isEmpty()) {
            set.add(nv);
        }

        AgeVal av = new AgeVal(animal);
        if (!av.validations.isEmpty()) {
            set.add(av);
        }

        WeightVal wv = new WeightVal(animal);
        if (!wv.validations.isEmpty()) {
            set.add(wv);
        }

        HeightVal hv = new HeightVal(animal);
        if (!hv.validations.isEmpty()) {
            set.add(hv);
        }

        return set;
    }

    Map<String, Set<ValidationError>> runChecks(List<Animal> animals) {
        Map<String, Set<ValidationError>> ans = new HashMap<>();
        animals.forEach(animal -> ans.put(animal.name(), makeSet(animal)));
        return ans;
    }



    class ValidationError {
        String field;
        List<String> validations = new ArrayList<>();
    }

    class NameVal extends ValidationError {
        NameVal(Animal animal) {
            field = "Name";
            validations = nameChecks(animal);
        }

        public List<String> nameChecks(Animal animal) {
            if (animal.name() == null || animal.name().isEmpty()) {
                validations.add("Пустое имя");
            } else if (animal.name().length() > MAX_NAME_LEN) {
                validations.add("Слишком длинное имя");
            }
            return validations;
        }

    }

    class AgeVal extends ValidationError {
        AgeVal(Animal animal) {
            field = "Age";
            validations = nameChecks(animal);
        }

        public List<String> nameChecks(Animal animal) {
            if (animal.age() < 0) {
                validations.add("Отрицательный возраст");
            }
            return validations;
        }
    }

    class WeightVal extends ValidationError {
        WeightVal(Animal animal) {
            field = "Weight";
            validations = nameChecks(animal);
        }

        public List<String> nameChecks(Animal animal) {
            if (animal.weight() < 0) {
                validations.add("Отрицательный Вес");
            }
            return validations;
        }
    }

    class HeightVal extends ValidationError {
        HeightVal(Animal animal) {
            field = "Height";
            validations = nameChecks(animal);
        }

        public List<String> nameChecks(Animal animal) {
            if (animal.height() < 0) {
                validations.add("Отрицательный рост");
            }
            return validations;
        }
    }
}
