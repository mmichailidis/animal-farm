package com.asdt.farm.animals;

import com.asdt.farm.Feeder;

public class Dog extends StaminaEnergyAnimal {
    private static final int FULL_STAMINA = 10;
    private static final int INITIAL_ENERGY = 3;

    public Dog(Feeder feeder, EatStrategy eatStrategy, String name) {
        super(feeder, eatStrategy, name, FULL_STAMINA, INITIAL_ENERGY);
    }

    public Dog(Feeder feeder, String name) {
        super(feeder, new SimpleEatStrategy(), name, FULL_STAMINA, INITIAL_ENERGY);
    }

}
