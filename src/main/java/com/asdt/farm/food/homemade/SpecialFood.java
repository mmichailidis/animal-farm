package com.asdt.farm.food.homemade;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.HOMEMADE;

public class SpecialFood extends AbstractFood {
    private static final Integer ENERGY = 2;
    private final static FoodOrigins ORIGIN = HOMEMADE;
    public final static String SPECIAL_FOOD_NAME = "SpecialFood";

    public SpecialFood() {
        super(FarmRandom.getInstance().getRandomUUID(), ENERGY, SPECIAL_FOOD_NAME, ORIGIN);
    }
}
