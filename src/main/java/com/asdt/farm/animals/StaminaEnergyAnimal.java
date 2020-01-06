package com.asdt.farm.animals;

import com.asdt.farm.Feeder;
import com.asdt.farm.util.Logger;

public abstract class StaminaEnergyAnimal extends Animal {
    private int fullStamina;
    private String name;
    private int stamina;
    private int energy;

    public StaminaEnergyAnimal(Feeder feeder, EatStrategy eatStrategy, String string, int fullStamina, int initialEnergy) {
        super(feeder, eatStrategy);
        name = string;
        this.fullStamina = fullStamina;
        stamina = fullStamina;
        energy = initialEnergy;
    }

    public StaminaEnergyAnimal(Feeder feeder, String string, int fullStamina, int initialEnergy) {
        super(feeder, new SimpleEatStrategy());
        this.fullStamina = fullStamina;
        stamina = fullStamina;
        energy = initialEnergy;
    }

    @Override
    protected boolean isHungry() {
        return (energy <= 0);
    }

    @Override
    protected boolean isTired() {
        return (stamina <= 0);
    }

    @Override
    public void move() {
        Logger.log(name + " is moving");
        energy--;
        stamina--;
        printState();
    }

    private void printState() {
        Logger.log(String.format("%s: stamina: %s, energy: %s\n", name, stamina, energy));
    }

    @Override
    public void eat() {
        Logger.log(name + " got hungry and is eating");
        energy = eatStrategy.eat(feeder);
        printState();
    }

    @Override
    public void sleep() {
        Logger.log(name + " got tired and is sleeping");
        stamina = fullStamina;
        energy = 0;
        printState();
    }

    public String getName() {
        return name;
    }

}
