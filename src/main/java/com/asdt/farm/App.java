package com.asdt.farm;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Farm farm = new Farm();

        Dog dog = new Dog("Lucy");
        Sloth sloth = new Sloth("Flash");

        farm.accept(dog);
        farm.accept(sloth);

        farm.simulateSteps(25);
    }
}
