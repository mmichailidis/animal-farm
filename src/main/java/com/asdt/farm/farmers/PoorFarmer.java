package com.asdt.farm.farmers;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.Feeder;
import com.asdt.farm.util.Logger;
import com.asdt.farm.food.SimpleFoodFactory;
import com.asdt.farm.food.homemade.SimpleFood;

import java.util.Random;

public class PoorFarmer implements Farmer {
    private Feeder feeder;
    private Integer refills = 0;
    private final Random random;

    public PoorFarmer() {
        random = FarmRandom.getInstance().getRandom();
    }

    @Override
    public void inform() {
        if (feeder.getFoodTypeCount(SimpleFood.SIMPLE_FOOD_NAME) == 0) {
            Logger.log("Farmer was informed that the feeder is empty and refills it. He will use simple food");
            feeder.addFood(SimpleFoodFactory.getInstance().makeFood(random.nextInt(2) + 5));
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
