package com.asdt.farm;

import com.asdt.farm.farmers.Observer;
import com.asdt.farm.food.homemade.Food;

import java.util.*;

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
        Collections.shuffle(this.currentFood);
    }

    public <T> Long getFoodTypeCount(final Class<T> clazz) {
        long count = 0L;
        for (final Food vL : currentFood) {
            if (clazz.isInstance(vL)) {
                count++;
            }
        }
        return count;
        // Same implementation but in Java8 streams
        // return currentFood.stream()
        //         .filter(clazz::isInstance)
        //         .count();
    }

    public Food getFood() {
        o.forEach(Observer::inform);

        return currentFood.remove(0);
    }

    public void printLeftoverFood() {
        final Map<Class<?>, List<Food>> stuff = new HashMap<>();
        for (final Food vL : currentFood) {
            if (stuff.containsKey(vL.getClass())) {
                stuff.get(vL.getClass()).add(vL);
            } else {
                stuff.put(vL.getClass(), new ArrayList<>());
                stuff.get(vL.getClass()).add(vL);
            }
        }

        stuff.forEach((k, v) -> Logger.log("From "
                + k.getName().split("\\.")[k.getName().split("\\.").length -1 ]
                + " was left : " + v.size()));
    }
}
