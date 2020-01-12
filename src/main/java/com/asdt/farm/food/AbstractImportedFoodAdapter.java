package com.asdt.farm.food;

import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.food.homemade.SimpleFood;
import com.asdt.farm.food.homemade.SpecialFood;
import com.asdt.farm.food.imported.AbstractImportedFood;
import com.asdt.farm.food.imported.SimpleImportedFood;
import com.asdt.farm.food.imported.SpecialImportedFood;

public abstract class AbstractImportedFoodAdapter implements Food, FoodOrigin {
    private AbstractImportedFood importedFood;

    public AbstractImportedFoodAdapter(final AbstractImportedFood importedFood) {
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

    @Override
    public String getName() {
        String importedFoodName = importedFood.getName();
        switch (importedFoodName) {
        case SpecialImportedFood.IMPORTED_SPECIAL_FOOD_NAME:
            return SpecialFood.SPECIAL_FOOD_NAME;
        case SimpleImportedFood.IMPORTED_SIMPLE_FOOD_NAME:
            return SimpleFood.SIMPLE_FOOD_NAME;
        }
        return importedFood.getName();
    }
}
