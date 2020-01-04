package com.asdt.farm;

public class AbstractEatStrategy {
    protected void eat(Feeder feeder, Integer times) {
        for (int i = 0; i < times; i++) {
            feeder.decreaseFood();
        }
    }
}
