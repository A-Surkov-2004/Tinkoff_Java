package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task20 {

    private static final int MAX_NAME_LEN = 30;

    String makeString(Animal animal) {
        StringBuilder str = new StringBuilder();

        NameVal nv = new NameVal(animal);
        if (!nv.validations.isEmpty()) {
            str.append(nv.field);
        }

        AgeVal av = new AgeVal(animal);
        if (!av.validations.isEmpty()) {
            str.append(av.field);
        }

        WeightVal wv = new WeightVal(animal);
        if (!wv.validations.isEmpty()) {
            str.append(wv.field);
        }

        HeightVal hv = new HeightVal(animal);
        if (!hv.validations.isEmpty()) {
            str.append(hv.field);
        }

        return str.toString();
    }

    Map<String, String> runChecks(List<Animal> animals) {
        Map<String, String> ans = new HashMap<>();
        animals.forEach(animal -> ans.put(animal.name(), makeString(animal)));
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
