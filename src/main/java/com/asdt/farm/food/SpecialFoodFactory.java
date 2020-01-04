package com.asdt.farm.food;

import com.asdt.farm.FarmRandom;
import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.food.homemade.SpecialFood;
import com.asdt.farm.food.imported.ImportedFood;
import com.asdt.farm.food.imported.SpecialImportedFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialFoodFactory implements FoodFactory {
    private static SpecialFoodFactory instance;

    private SpecialFoodFactory() {
    }

    public static SpecialFoodFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SpecialFoodFactory();
        }
        return instance;
    }

    /**
     * Java8 streamed loop.
     * @see SimpleFoodFactory#makeFood(Integer)
     *
     * @param count How many objects it will create
     * @return A {@link List} of {@link Food} and {@link ImportedFood} randomly distributed.
     */
    @Override
    public List<Food> makeFood(final Integer count) {
        List<Food> foodList = new ArrayList<>();
        for(int i = 0; i<count; i++) {
            if(FarmRandom.getInstance().getRandom().nextBoolean()) {
                foodList.add(new SpecialFood());
            } else {
                foodList.add(new SpecialImportedFoodAdapter(new SpecialImportedFood()));
            }
        }
        return foodList;

    //     return IntStream.rangeClosed(1, count)
    //             .boxed()
    //             .map(ignore -> FarmRandom.getInstance().getRandom().nextBoolean()
    //                     ? new SpecialFood()
    //                     : new SpecialImportedFoodAdapter(new SpecialImportedFood()))
    //             .collect(Collectors.toList());
    }
}
