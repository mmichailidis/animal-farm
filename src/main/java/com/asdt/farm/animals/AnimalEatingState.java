package com.asdt.farm.animals;

public class AnimalEatingState implements AnimalState {

    @Override
    public void act(AnimalState context, Animal animal) {
        animal.eat();
        if (animal.isTired()) {
            animal.setState(new AnimalSleepingState());
        } else {
            animal.setState(new AnimalRunningState());
        }
    }
}
