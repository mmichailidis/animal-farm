package com.asdt.farm;

import java.util.Random;
import java.util.UUID;

/**
 * This is a singleton factory that returns the random number generator and the
 * UUID.randomUUID().toString.
 * 
 * For testing purposes the field setToFake is set at creation so that results
 * are reproducible.
 * 
 * To reproduce results call 
 * 
 * FarmRandom.isfake = true; 
 * 
 * before you call the
 * 
 * first getInstance()
 */
public class FarmRandom {
    private static FarmRandom instance;
    public static boolean isfake = false;

    private Random random;
    private boolean setToFake = false;
    private long usedSeed;

    private FarmRandom() {
        random = new Random();
        setToFake = false;
    }

    private FarmRandom(long seed) {
        Logger.log("SAME RANDOM NUMBERS WITH SEED: " + seed);
        random = new Random(seed);
        setToFake = true;
        usedSeed = seed;
    }

    public static FarmRandom getInstance() {
        if (instance == null) {
            if (isfake) {
                instance = new FarmRandom(0);
            } else {
                instance = new FarmRandom();
            }
        }
        return instance;
    }

    public Random getRandom() {
        return random;
    }

    public String getRandomUUID() {
        if (setToFake) {
            return Long.valueOf(random.nextLong()).toString();
        }
        return UUID.randomUUID().toString();
    }

    public void reset() {
        random = new Random(usedSeed);
    }

}
