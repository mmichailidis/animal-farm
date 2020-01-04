package com.asdt.farm.food;

import com.asdt.farm.FarmRandom;
import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.food.homemade.SimpleFood;
import com.asdt.farm.food.imported.ImportedFood;
import com.asdt.farm.food.imported.SimpleImportedFood;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleFoodFactory implements FoodFactory {
    private static SimpleFoodFactory instance;

    private SimpleFoodFactory() {
    }

    public static SimpleFoodFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SimpleFoodFactory();
        }
        return instance;
    }

    /**
     * Java8 streamed loop.
     *
     * @param count How many objects it will create
     * @return A {@link List} of {@link Food} and {@link ImportedFood} randomly distributed.
     */
    @Override
    public List<Food> makeFood(final Integer count) {
        List<Food> foodList = new ArrayList<>();
        for(int i = 0; i<count; i++) {
            if(FarmRandom.getInstance().getRandom().nextBoolean()) {
                foodList.add(new SimpleFood());
            } else {
                foodList.add(new SimpleImportedFoodAdapter(new SimpleImportedFood()));
            }
        }
        return foodList;
        // return IntStream.rangeClosed(1, count)//Create the loop
        //         .boxed() //Box the integers into classes ( int is primitive while Integer is a class. That is boxing)
        //         .map(ignore -> FarmRandom.getInstance().getRandom().nextBoolean() // Randomly take true or false
        //                 ? new SimpleFood() // if true create a SimpleFood
        //                 : new SimpleImportedFoodAdapter(new SimpleImportedFood())) // else create an ImportedFood
        //         .collect(Collectors.toList()); // collect the results into a List and return it
    }
}
