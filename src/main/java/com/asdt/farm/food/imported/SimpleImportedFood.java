package com.asdt.farm.food.imported;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.TEXAS;

public class SimpleImportedFood extends AbstractImportedFood {
    private final static Integer POWER = 1;
    private final static FoodOrigins ORIGIN = TEXAS;
    public final static String IMPORTED_SIMPLE_FOOD_NAME = "ImportedSimpleFood";

    public SimpleImportedFood() {
        super(FarmRandom.getInstance().getRandomUUID(), POWER, IMPORTED_SIMPLE_FOOD_NAME ,ORIGIN);
    }
}
