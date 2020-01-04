package com.asdt.farm;

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
        System.out.println(name + " is moving");
        energy--;
        stamina--;
        printState();
    }

    @Override
    protected void eat() {
        System.out.println(name + " got hungry and is eating");
        energy = ENERGY;
        eatStrategy.eat(feeder);
        printState();
    }

    @Override
    protected void sleep() {
        System.out.println(name + " got tired and is sleeping");
        stamina = STAMINA;
        energy = 0;
        printState();
    }

    private void printState() {
        System.out.printf("%s: stamina: %s, energy: %s\n", name, stamina, energy);
    }
}
