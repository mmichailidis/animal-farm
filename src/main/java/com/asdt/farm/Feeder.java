package com.asdt.farm;

import com.asdt.farm.farmers.Observer;
import com.asdt.farm.food.homemade.Food;
import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.util.Logger;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Feeder {
    private List<Food> currentFood;
    public List<Observer> o;

    public Feeder() {
        this.currentFood = new ArrayList<>();
        this.o = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        this.o.add(o);
    }

    public void addFood(final List<Food> newFood) {
        this.currentFood.addAll(newFood);
        Collections.shuffle(this.currentFood, FarmRandom.getInstance().getRandom());
    }

    public Long getFoodTypeCount(String foodName) {
        long count = 0L;
        for (final Food vL : currentFood) {
            if (vL.getName().equals(foodName)) {
                count++;
            }
        }
        return count;
    }

    public Food getFood() {
        o.forEach(Observer::inform);

        return currentFood.remove(0);
    }

    /**
     * Three variations of how this can be implemented. The first two use the Java's superclass of all classes
     * which is called "{@link Class}" in order to locate and count each {@link Food} object separately. The first
     * approach prints everything using a streamed functioned. The second uses a ForLoop which is the equivalent of
     * the streaming function. The last one in order to count the different items without accessing the {@link Class}
     * it requires either a name ( which is the approach followed) or an other way of identifying the different items
     * and storing them in a {@link Map} in order to count them. The variation between 3.1 and 3.2 is the use of an
     * other class called {@link AtomicInteger} which in this scenario does not require replacing the value of the map
     */
    public void printLeftoverFood() {
        // solution (1), (2)
        // final Map<Class<?>, List<Food>> stuff = new HashMap<>();
        // for (final Food vL : currentFood) {
        //     if (stuff.containsKey(vL.getClass())) {
        //         stuff.get(vL.getClass()).add(vL);
        //     } else {
        //         stuff.put(vL.getClass(), new ArrayList<>());
        //         stuff.get(vL.getClass()).add(vL);
        //     }
        // }

        // solution (1)
        // stuff.forEach((k, v) -> Logger.log("From "
        //         + k.getName().split("\\.")[k.getName().split("\\.").length -1 ]
        //         + " was left : " + v.size()));

        // solution (2)
        // for (Entry<Class<?>, List<Food>> entry : stuff.entrySet()) {
        //     Class<?> k = entry.getKey();
        //     List<Food> v = entry.getValue();
        //     Logger.log("From "
        //     + k.getName().split("\\.")[k.getName().split("\\.").length -1 ]
        //     + " was left : " + v.size());
        // }

        // solution (3.1)
        // final Map<String, AtomicInteger> counters = new HashMap<>();
        // for (final Food vL : currentFood) {
        //     final String name = vL.getName();
        //     if (counters.containsKey(name)) {
        //         counters.get(name).incrementAndGet();
        //     } else {
        //         counters.put(vL.getName(), new AtomicInteger(1));
        //     }
        // }

        // solution (3.2)
        final Map<String, Integer> counters = new HashMap<>();
        for (final Food vL : currentFood) {
            final String name = vL.getName();
            if (counters.containsKey(name)) {
                counters.put(name, counters.get(name) + 1);
            } else {
                counters.put(vL.getName(), 1);
            }
        }

        for (final Map.Entry<String, Integer> vL : counters.entrySet()) {
            Logger.log("From " + vL.getKey() + " was left : " + vL.getValue());
        }
    }
}
