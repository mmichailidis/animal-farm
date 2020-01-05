package com.asdt.farm.food.imported;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.ENGLAND;

public class SpecialImportedFood extends AbstractImportedFood {
    private final static Integer POWER = 2;
    private final static FoodOrigins ORIGIN = ENGLAND;
    public final static String IMPORTED_SPECIAL_FOOD_NAME = "ImportedSpecialFood";

    public SpecialImportedFood() {
        super(FarmRandom.getInstance().getRandomUUID(), POWER, IMPORTED_SPECIAL_FOOD_NAME, ORIGIN);
    }
}
