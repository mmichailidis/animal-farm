package com.asdt.farm.animals;

public interface AnimalState {
    void act(AnimalState context, Animal animal);
}
