package com.asdt.farm.food.imported;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.food.FoodOrigins;

import static com.asdt.farm.food.FoodOrigins.ENGLAND;

public class SpecialImportedFood extends AbstractFood {
    private final static Integer POWER = 2;
    private final static FoodOrigins ORIGIN = ENGLAND;
    private final static String NAME = "ImportedSpecialFood";

    public SpecialImportedFood() {
        super(FarmRandom.getInstance().getRandomUUID(), POWER, NAME, ORIGIN);
    }
}
