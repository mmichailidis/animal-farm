package com.asdt.farm.food.imported;

import com.asdt.farm.food.FoodOrigin;
import com.asdt.farm.food.FoodOrigins;

public abstract class AbstractFood implements ImportedFood, FoodOrigin {
    private final String identification;
    private final Integer power;
    private FoodOrigins foodOrigins;

    protected AbstractFood(final String identification,
                           final Integer power,
                           final FoodOrigins foodOrigins) {
        this.identification = identification;
        this.power = power;
        this.foodOrigins = foodOrigins;
    }

    @Override
    public String getIdentification() {
        return identification;
    }

    @Override
    public Integer getPower() {
        return power;
    }

    @Override
    public FoodOrigins getFoodOrigin() {
        return foodOrigins;
    }
}
