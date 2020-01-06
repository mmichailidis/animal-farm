package com.asdt.farm.animals;

import com.asdt.farm.Feeder;

public class Sloth extends StaminaEnergyAnimal {
    private static final int FULL_STAMINA = 2;
    private static final int INITIAL_ENERGY = 2;

    public Sloth(Feeder feeder, EatStrategy eatStrategy, String name) {
        super(feeder, eatStrategy, name, FULL_STAMINA, INITIAL_ENERGY);
    }

    public Sloth(Feeder feeder, String name) {
        super(feeder, new ExtraEatStrategy(), name, FULL_STAMINA, INITIAL_ENERGY);
    }

}
