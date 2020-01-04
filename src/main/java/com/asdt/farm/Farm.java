package com.asdt.farm;

import com.asdt.farm.farmers.Farmer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farm {

    private List<Animal> animals = new ArrayList<>();
    private List<Farmer> farmers = new ArrayList<>();

    public Farm(final Feeder feeder, final Farmer... farmers) {
        for (final Farmer vL : farmers) {
            vL.setFeeder(feeder);
        }

        this.farmers.addAll(Arrays.asList(farmers));
    }

    public void accept(final Animal animal) {
        animals.add(animal);
    }

    public void simulateSteps(final int steps) {
        for (int i = 0; i < steps; i++) {
            Logger.log("Step: " + (i + 1));
            for (Animal animal : animals) {
                animal.simulateStep();
            }
        }
    }

    /**
     * @param type Dog.class , Sloth.class etc
     * @param <T>  the *.class requested from parameter
     * @return All the items matching the requested class
     */
    public <T> List<T> listAllOf(final Class<T> type) {
        final List<T> toReturn = new ArrayList<>();
        for (final Animal vL : animals) {
            if (type.isInstance(vL)) {
                toReturn.add(type.cast(vL));
            }
        }
        return toReturn;
    }

}
