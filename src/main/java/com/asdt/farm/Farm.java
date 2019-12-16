package com.asdt.farm;

public class Farm {
    Animal animal;

    public void accept(Dog dog) {
        animal = dog;
    }

    public void simulate(int days) {
        for (int i = 0; i < days; i++) {
            System.out.println("DAY: " + (i+1));
            animal.simulateDay();
        }
    }

}
