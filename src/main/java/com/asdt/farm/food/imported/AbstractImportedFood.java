package com.asdt.farm.food.imported;

import com.asdt.farm.food.FoodOrigin;
import com.asdt.farm.food.FoodOrigins;

public abstract class AbstractImportedFood implements ImportedFood, FoodOrigin {
    private final String identification;
    private final Integer power;
    private String name;
    private FoodOrigins foodOrigins;

    protected AbstractImportedFood(final String identification,
                           final Integer power,
                           final String name,
                           final FoodOrigins foodOrigins) {
        this.identification = identification;
        this.power = power;
        this.name = name;
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

    @Override
    public String getName() {
        return name;
    }
}
