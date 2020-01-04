package com.asdt.farm.food;

import com.asdt.farm.food.homemade.Food;

import java.util.List;

public interface FoodFactory {
    List<Food> makeFood(final Integer count);
}
