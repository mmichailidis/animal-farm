package com.asdt.farm;

public class SimpleEatStrategy extends AbstractEatStrategy implements EatStrategy {
    private final static Integer TIMES = 1;

    @Override
    public void eat(Feeder feeder) {
        eat(feeder, TIMES);
    }
}
