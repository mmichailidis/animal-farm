package com.asdt.farm.food.homemade;

import com.asdt.farm.food.FoodOrigin;
import com.asdt.farm.food.FoodOrigins;

public abstract class AbstractFood implements Food, FoodOrigin {
    private final String barCode;
    private final Integer energy;
    private FoodOrigins foodOrigins;

    protected AbstractFood(final String barCode,
                           final Integer energy,
                           final FoodOrigins foodOrigins) {
        this.barCode = barCode;
        this.energy = energy;
        this.foodOrigins = foodOrigins;
    }

    @Override
    public String getBarCode() {
        return barCode;
    }

    @Override
    public Integer getEnergy() {
        return energy;
    }

    @Override
    public FoodOrigins getFoodOrigin() {
        return foodOrigins;
    }
}
