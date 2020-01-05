package com.asdt.farm;

import com.asdt.farm.util.FarmRandom;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FarmRandom.setFake(true);
        FarmRandom.getInstance().reset();
        (new Simulation()).start(25);
    }

}
