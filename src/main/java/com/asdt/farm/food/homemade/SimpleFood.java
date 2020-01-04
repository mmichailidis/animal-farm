package com.asdt.farm.food.homemade;

import com.asdt.farm.food.FoodOrigins;

import java.util.UUID;

import static com.asdt.farm.food.FoodOrigins.HOMEMADE;

public class SimpleFood extends AbstractFood {
    private static final Integer ENERGY = 1;
    private final static FoodOrigins ORIGIN = HOMEMADE;

    public SimpleFood() {
        super(UUID.randomUUID().toString(), ENERGY, ORIGIN);
    }
}
