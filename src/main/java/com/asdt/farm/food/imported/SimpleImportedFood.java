package com.asdt.farm.food.imported;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.TEXAS;

public class SimpleImportedFood extends AbstractImportedFood {
    private final static Integer POWER = 1;
    private final static FoodOrigins ORIGIN = TEXAS;
    private final static String NAME = "ImportedSimpleFood";

    public SimpleImportedFood() {
        super(FarmRandom.getInstance().getRandomUUID(), POWER, NAME ,ORIGIN);
    }
}
