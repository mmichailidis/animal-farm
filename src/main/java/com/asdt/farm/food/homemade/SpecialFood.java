package com.asdt.farm.food.homemade;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.HOMEMADE;

public class SpecialFood extends AbstractFood {
    private static final Integer ENERGY = 2;
    private final static FoodOrigins ORIGIN = HOMEMADE;
    private final static String NAME = "SpecialFood";

    public SpecialFood() {
        super(FarmRandom.getInstance().getRandomUUID(), ENERGY, NAME, ORIGIN);
    }
}
