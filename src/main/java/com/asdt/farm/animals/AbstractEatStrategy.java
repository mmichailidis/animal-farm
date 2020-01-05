package com.asdt.farm.animals;

import com.asdt.farm.Feeder;
import com.asdt.farm.util.Logger;
import com.asdt.farm.food.FoodOrigin;
import com.asdt.farm.food.homemade.Food;

public class AbstractEatStrategy {
    protected Integer eat(final Feeder feeder, final Integer times) {
        int energyAdded = 0;
        for (int i = 0; i < times; i++) {
            final Food food = feeder.getFood();

            Logger.log("The food that was eaten was from : "
                    + ((FoodOrigin) food).getFoodOrigin()
                    + " and provided "
                    + food.getEnergy()
                    + " energy");

            energyAdded += food.getEnergy();
        }
        return energyAdded;
    }
}
