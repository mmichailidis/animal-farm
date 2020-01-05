package com.asdt.farm;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        FarmRandom.isfake = true;
        FarmRandom.getInstance().reset();
        (new Simulation()).start(25);
    }

}
