package com.asdt.farm.food;

import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.food.imported.AbstractImportedFood;

public class ImportedFoodAdapter implements Food, FoodOrigin {
    private AbstractImportedFood importedFood;

    public ImportedFoodAdapter(final AbstractImportedFood importedFood) {
        this.importedFood = importedFood;
    }

    @Override
    public String getBarCode() {
        return importedFood.getIdentification();
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
