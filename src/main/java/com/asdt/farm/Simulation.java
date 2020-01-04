package com.asdt.farm;

import com.asdt.farm.farmers.PoorFarmer;
import com.asdt.farm.farmers.RichFarmer;

import java.util.List;

public class Simulation {
    public Simulation() {

    }

    public void start() {
        final Feeder feeder = new Feeder();
        final PoorFarmer poorFarmer = new PoorFarmer();
        final RichFarmer richFarmer = new RichFarmer();
        final Farm farm = new Farm(feeder, poorFarmer, richFarmer);

        final Dog dog = new Dog(feeder, "Lucy");
        final Dog dog2 = new Dog(feeder, new ExtraEatStrategy(), "Dolly");
        final Dog dog3 = new Dog(feeder, "Molly");
        final Sloth sloth = new Sloth(feeder, "Flash");
        final Sloth sloth2 = new Sloth(feeder, new SimpleEatStrategy(), "Zoom");

        farm.accept(dog);
        farm.accept(dog2);
        farm.accept(dog3);
        farm.accept(sloth);
        farm.accept(sloth2);

        farm.simulateSteps(45);

        // Logger.log("\nFeeder food left : " + feeder.);
        Logger.log("Total refills : " + poorFarmer.getRefills() + "\n");
        feeder.printLeftoverFood();

        final List<Dog> dogs = farm.listAllOf(Dog.class);

        Logger.log("\nAll the dogs contained in the farm : \n");

        for (Dog vL : dogs) {
            Logger.log(vL.getName());
        }

        final List<Sloth> sloths = farm.listAllOf(Sloth.class);

        Logger.log("\nAll the sloths contained in the farm : \n");

        for (Sloth vL : sloths) {
            Logger.log(vL.getName());
        }
    }

}
