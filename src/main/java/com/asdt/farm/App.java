package com.asdt.farm;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final Feeder feeder = new Feeder();
        final Farmer farmer = new Farmer();
        Farm farm = new Farm(farmer, feeder);

        Dog dog = new Dog(feeder, "Lucy");
        Dog dog2 = new Dog(feeder, "Dolly");
        Dog dog3 = new Dog(feeder, "Molly");
        Sloth sloth = new Sloth(feeder, "Flash");

        farm.accept(dog);
        farm.accept(dog2);
        farm.accept(dog3);
        farm.accept(sloth);

        farm.simulateSteps(45);

        System.out.println("\nFeeder food left : " + feeder.getFood());
        System.out.println("Total refills : " + farmer.getRefills());

        final List<Dog> animals = farm.listAllOf(Dog.class);

        System.out.println("\nAll the dogs contained in the farm : \n");

        for (Dog vL : animals) {
            System.out.println(vL.getName());
        }
    }
}
