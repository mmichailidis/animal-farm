package com.asdt.farm;

public class Feeder {
    private final static Integer TOTAL_FOOD = 10;

    private Integer currentFood;
    public Observer<Integer> o;

    public Feeder() {
        this.currentFood = TOTAL_FOOD;
    }

    public void addObserver(Observer<Integer> o) {
        this.o = o;
    }

    public void decreaseFood() {
        o.inform(--currentFood);
    }

    public void setCurrentFood(Integer currentFood) {
        this.currentFood = currentFood;
    }

    public Integer getFood() {
        return currentFood;
    }
}
