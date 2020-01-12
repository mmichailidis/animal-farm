package com.asdt.farm.food.homemade;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.HOMEMADE;

public class SimpleFood extends AbstractFood {
    private static final Integer ENERGY = 1;
    private final static FoodOrigins ORIGIN = HOMEMADE;
    public final static String SIMPLE_FOOD_NAME = "SimpleFood";

    public SimpleFood() {
        super(FarmRandom.getInstance().getRandomUUID(), ENERGY, SIMPLE_FOOD_NAME, ORIGIN);
    }
}
