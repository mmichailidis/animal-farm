package com.asdt.farm.food.imported;

import com.asdt.farm.food.FoodOrigins;

import java.util.UUID;

import static com.asdt.farm.food.FoodOrigins.TEXAS;

public class SimpleImportedFood extends AbstractFood {
    private final static Integer POWER = 1;
    private final static FoodOrigins ORIGIN = TEXAS;

    public SimpleImportedFood() {
        super(UUID.randomUUID().toString(), POWER, ORIGIN);
    }
}
