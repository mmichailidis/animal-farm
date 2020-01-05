package com.asdt.farm.util;

import java.util.Random;
import java.util.UUID;

/**
 * This is a singleton factory that returns the random number generator and the
 * UUID.randomUUID().toString.
 * 
 * To reproduce results call
 * 
 * <p><code>FarmRandom.isfake = true; </code></p>
 * 
 * before you call the first <code>getInstance()</code>
 */
public class FarmRandom {
    private static FarmRandom instance;
    private static boolean isFake = false;

    public static void setFake(boolean isFake){
        FarmRandom.isFake = isFake;
    }

    public static boolean isFake(){
        return isFake;
    }

    private Random random;
    private boolean setToFake;
    private long usedSeed;

    private FarmRandom() {
        random = new Random();
        setToFake = false;
    }

    private FarmRandom(long seed) {
        random = new Random(seed);
        setToFake = true;
        usedSeed = seed;
    }

    public static FarmRandom getInstance() {
        if (instance == null) {
            if (isFake) {
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
        instance = new FarmRandom(usedSeed);
    }
}
