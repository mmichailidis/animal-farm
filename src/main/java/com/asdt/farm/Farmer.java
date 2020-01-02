package com.asdt.farm;

import java.util.function.Function;

public class Farmer implements Observer<Integer> {
    private Feeder feeder;
    private Integer refills = 0;

    @Override
    public void inform(Integer current) {
        if (current == 0) {
            System.out.println("Farmer was informed that the feeder is empty and refills it.");
            feeder.setCurrentFood(10);
            refills++;
        }
    }

    public void setFeeder(Feeder feeder) {
        this.feeder = feeder;
        feeder.addObserver(this);
    }

    public Integer getRefills() {
        return refills;
    }
}
