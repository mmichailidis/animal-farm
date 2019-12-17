package com.asdt.farm;

public class AnimalSleepingState implements AnimalState {

    @Override
    public void act (AnimalState context, Animal animal) {
        animal.sleep();
        if (animal.isHungry()) {
            animal.setState(new AnimalEatingState());
        } else {
            animal.setState(new AnimalRunningState());
        }
    }
}
