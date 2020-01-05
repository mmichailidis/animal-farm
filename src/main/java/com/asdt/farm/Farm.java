package com.asdt.farm;

import com.asdt.farm.animals.Animal;
import com.asdt.farm.farmers.Farmer;
import com.asdt.farm.util.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Farm {

    private List<Animal> animals = new ArrayList<>();
    private List<Farmer> farmers = new ArrayList<>();

    /**
     *
     * @param feeder The feeder of the farm
     * @param farmers This is called "varargs" and accepts multiple items as different arguments.
     *                The final result is merging all those arguments into an Array.
     *                Similar to Farmer[] but does not require instantiation
     */
    public Farm(final Feeder feeder, final Farmer... farmers) {
        for (final Farmer vL : farmers) {
            vL.setFeeder(feeder);
        }

        this.farmers.addAll(Arrays.asList(farmers));
    }

    public void accept(final Animal animal) {
        animals.add(animal);
    }

    /**
     * For every step we iterate to all the animals so we will simulate their steps
     *
     * @param steps The steps that the farm will simulate
     */
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
