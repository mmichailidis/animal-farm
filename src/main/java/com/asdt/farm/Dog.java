package com.asdt.farm;

public class Dog extends Animal {
    private final int STAMINA = 10;
    private final int FOOD = 3;
    private String name;
    private int stamina;
    private int food;
	public Dog(String string) {
        name = string;
        stamina = STAMINA;
        food = FOOD;
	}

    @Override
    public boolean isTired() {
        return stamina <= 0;
    }

    @Override
    public boolean isHungry() {
        return food <= 0;
    }

    @Override
    public void move() {
        System.out.println(name + " is moving");
        food--;
        stamina--;
        printState();
    }

    private void printState() {
        System.out.println(String.format("%s: stamina: %s, food: %s\n", name, stamina, food));
    }

    @Override
    public void eat() {
        System.out.println(name + " got hungry and is eating");
        food = FOOD;
        printState();
    }

    @Override
    public void sleep() {
        System.out.println(name + " got tired and is sleeping");
        stamina = STAMINA;
        food = 0;
        printState();
    }

}
