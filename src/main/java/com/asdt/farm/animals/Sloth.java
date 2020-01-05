package com.asdt.farm.animals;

import com.asdt.farm.Feeder;
import com.asdt.farm.Logger;

public class Sloth extends Animal {
    private final int STAMINA = 2;
    private final int ENERGY = 2;
    private String name;
    private int stamina;
    private int energy;

    public Sloth(Feeder feeder, EatStrategy eatStrategy, String string) {
        super(feeder, eatStrategy);
        name = string;
        stamina = STAMINA;
        energy = ENERGY;
    }

    public Sloth(Feeder feeder, String string) {
        super(feeder, new ExtraEatStrategy());
        name = string;
        stamina = STAMINA;
        energy = ENERGY;
    }

    @Override
    protected boolean isHungry() {
        return energy <= 0;
    }

    @Override
    protected boolean isTired() {
        return stamina <= 0;
    }

    @Override
    protected void move() {
        Logger.log(name + " is moving");
        energy--;
        stamina--;
        printState();
    }

    @Override
    protected void eat() {
        Logger.log(name + " got hungry and is eating");
        energy = eatStrategy.eat(feeder);
        printState();
    }

    @Override
    protected void sleep() {
        Logger.log(name + " got tired and is sleeping");
        stamina = STAMINA;
        energy = 0;
        printState();
    }

    public String getName() {
        return name;
    }

    private void printState() {
        Logger.log(String.format("%s: stamina: %s, energy: %s\n", name, stamina, energy));
    }
}
