package com.asdt.farm.food.imported;

import com.asdt.farm.food.FoodOrigins;

import java.util.UUID;

import static com.asdt.farm.food.FoodOrigins.ENGLAND;

public class SpecialImportedFood extends AbstractFood {
    private final static Integer POWER = 2;
    private final static FoodOrigins ORIGIN = ENGLAND;

    public SpecialImportedFood() {
        super(UUID.randomUUID().toString(), POWER, ORIGIN);
    }
}
