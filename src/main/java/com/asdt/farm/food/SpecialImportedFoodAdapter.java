package com.asdt.farm.food;

import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.food.imported.SpecialImportedFood;

public class SpecialImportedFoodAdapter implements Food, FoodOrigin {
    private SpecialImportedFood importedFood;

    public SpecialImportedFoodAdapter(final SpecialImportedFood importedFood) {
        this.importedFood = importedFood;
    }

    @Override
    public String getBarCode() {
        return importedFood.getIdentification();
    }

    @Override
    public String getName() {
        return importedFood.getName();
    }

    @Override
    public Integer getEnergy() {
        return importedFood.getPower();
    }

    @Override
    public FoodOrigins getFoodOrigin() {
        return importedFood.getFoodOrigin();
    }
}
