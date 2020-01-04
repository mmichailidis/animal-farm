package com.asdt.farm.food.imported;

import com.asdt.farm.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.TEXAS;

public class SimpleImportedFood extends AbstractFood {
    private final static Integer POWER = 1;
    private final static FoodOrigins ORIGIN = TEXAS;

    public SimpleImportedFood() {
        super(FarmRandom.getInstance().getRandomUUID(), POWER, ORIGIN);
    }
}
