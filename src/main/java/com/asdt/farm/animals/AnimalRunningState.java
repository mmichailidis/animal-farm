package com.asdt.farm.animals;

public class AnimalRunningState implements AnimalState {

    @Override
    public void act(AnimalState context, Animal animal) {
        animal.move();
        if (animal.isTired()) {
            animal.setState(new AnimalSleepingState());
        } else if (animal.isHungry()) {
            animal.setState(new AnimalEatingState());
        }
    }
}
