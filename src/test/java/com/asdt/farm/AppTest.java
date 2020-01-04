package com.asdt.farm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void sanityCheck() {
        Random random1 = new Random(0);
        int count = 50;

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list1.add(random1.nextInt());
        }

        Random random2 = new Random(0);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list2.add(random2.nextInt());
        }

        assertEquals(list1, list2);
    }


    @Test
    public void testRandomFake() {
        int count = 5000;
        FarmRandom.isfake = true;
        FarmRandom.getInstance().reset();
        Random random = FarmRandom.getInstance().getRandom();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list1.add(random.nextInt());
        }

        FarmRandom.getInstance().reset();

        random = FarmRandom.getInstance().getRandom();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list2.add(random.nextInt());
        }

        assertEquals(list1, list2);
    }

    @Test
    public void testRandomUUIDFake() {
        int count = 500;
        FarmRandom.isfake = true;

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list1.add(FarmRandom.getInstance().getRandomUUID());
        }

        FarmRandom.getInstance().reset();
        
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list2.add(FarmRandom.getInstance().getRandomUUID());
        }

        assertEquals(list1, list2);
    }

    // @Test
    public void testSameOutput() {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(
                Paths.get("/home/dimitris/git/playground/asdt_class_2019/animal-farm/animal-farm/output"),
                StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileContent = contentBuilder.toString();

        /**
         * run the simulation with same random numbers and fake UUIDs
         * 
         * Collect all the output in a string
         */
        Logger.collectInString(true);
        FarmRandom.isfake = true;
        (new Simulation()).start(50);

        assertEquals(fileContent, Logger.getLog());
    }
}
