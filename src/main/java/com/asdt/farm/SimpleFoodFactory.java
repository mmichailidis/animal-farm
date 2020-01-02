package com.asdt.farm;

import java.util.Objects;

public class SimpleFoodFactory implements FoodFactory {
    private static final Integer FOOD_GENERATE = 10;

    private static SimpleFoodFactory instance;

    private SimpleFoodFactory() {
    }

    public static SimpleFoodFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SimpleFoodFactory();
        }
        return instance;
    }

    @Override
    public Integer makeFood() {
        return FOOD_GENERATE;
    }
}
