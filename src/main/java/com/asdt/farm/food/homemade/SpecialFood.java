package com.asdt.farm.food.homemade;

import com.asdt.farm.food.FoodOrigins;

import java.util.UUID;

import static com.asdt.farm.food.FoodOrigins.HOMEMADE;

public class SpecialFood extends AbstractFood {
    private static final Integer ENERGY = 2;
    private final static FoodOrigins ORIGIN = HOMEMADE;

    public SpecialFood() {
        super(UUID.randomUUID().toString(), ENERGY, ORIGIN);
    }
}
