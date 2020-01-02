package com.asdt.farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private List<Animal> animals = new ArrayList<>();

    public Farm(Farmer farmer, Feeder feeder) {
        farmer.setFeeder(feeder);
    }

    public void accept(Animal animal) {
        animals.add(animal);
    }

    public void simulateSteps(int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("Step: " + (i + 1));
            for (Animal animal : animals) {
                animal.simulateStep();
            }
        }
    }

    /**
     *
     * @param type Dog.class , Sloth.class etc
     * @param <T> the *.class requested from parameter
     * @return All the items matching the requested class
     */
    public <T> List<T> listAllOf(Class<T> type) {
        List<T> toReturn = new ArrayList<>();
        for (Animal vL : animals) {
            if (type.isInstance(vL)) {
                toReturn.add(type.cast(vL));
            }
        }
        return toReturn;
    }

}
