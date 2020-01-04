package com.asdt.farm;

public class Dog extends Animal {
    private final int STAMINA = 10;
    private final int ENERGY = 3;
    private String name;
    private int stamina;
    private int energy;

    public Dog(Feeder feeder, EatStrategy eatStrategy, String string) {
        super(feeder, eatStrategy);
        name = string;
        stamina = STAMINA;
        energy = ENERGY;
    }

    public Dog(Feeder feeder, String string) {
        super(feeder, new SimpleEatStrategy());
        name = string;
        stamina = STAMINA;
        energy = ENERGY;
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
        System.out.println(name + " is moving");
        energy--;
        stamina--;
        printState();
    }

    private void printState() {
        System.out.println(String.format("%s: stamina: %s, energy: %s\n", name, stamina, energy));
    }

    @Override
    public void eat() {
        System.out.println(name + " got hungry and is eating");
        energy = eatStrategy.eat(feeder);
        printState();
    }

    @Override
    public void sleep() {
        System.out.println(name + " got tired and is sleeping");
        stamina = STAMINA;
        energy = 0;
        printState();
    }

    public String getName() {
        return name;
    }
}
