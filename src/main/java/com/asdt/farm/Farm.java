package com.asdt.farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private List<Animal> animals = new ArrayList<>();

    public void accept(Animal animal) {
        animals.add(animal);
    }
    
    public void simulateSteps (int steps) {
        for (int i = 0; i < steps; i++) {
            System.out.println("Step: " + (i + 1));
            for (Animal animal: animals) {
                animal.simulateStep();
            }
        }
    }

}
