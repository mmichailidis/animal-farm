package com.asdt.farm;

public class ExtraEatStrategy extends AbstractEatStrategy implements EatStrategy {
    private final static Integer TIMES = 2;

    @Override
    public void eat(Feeder feeder) {
        eat(feeder, TIMES);
    }
}
