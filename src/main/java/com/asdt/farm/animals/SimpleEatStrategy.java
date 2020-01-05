package com.asdt.farm.animals;

import com.asdt.farm.Feeder;

public class SimpleEatStrategy extends AbstractEatStrategy implements EatStrategy {
    private final static Integer TIMES = 1;

    @Override
    public Integer eat(final Feeder feeder) {
        return eat(feeder, TIMES);
    }
}
