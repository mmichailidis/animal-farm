package com.asdt.farm.farmers;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.Feeder;
import com.asdt.farm.util.Logger;
import com.asdt.farm.food.SpecialFoodFactory;
import com.asdt.farm.food.homemade.SpecialFood;

import java.util.Random;

public class RichFarmer implements Farmer {
    private Feeder feeder;
    private Integer refills = 0;
    private final Random random;

    public RichFarmer() {
        random = FarmRandom.getInstance().getRandom();
    }

    @Override
    public void inform() {
        if (feeder.getFoodTypeCount(SpecialFood.SPECIAL_FOOD_NAME) == 0) {
            Logger.log("Farmer was informed that the feeder is empty and refills it. He will use special food");
            feeder.addFood(SpecialFoodFactory.getInstance().makeFood(random.nextInt(2) + 5));
            refills++;
        }
    }

    @Override
    public void setFeeder(final Feeder feeder) {
        this.feeder = feeder;
        feeder.addObserver(this);
    }

    @Override
    public Integer getRefills() {
        return refills;
    }
}
