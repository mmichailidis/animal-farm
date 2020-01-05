package com.asdt.farm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import com.asdt.farm.util.FarmRandom;
import com.asdt.farm.util.Logger;
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
        FarmRandom.getInstance().reset();
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

    /**
     * The purpose of this test is to test refactorings in which the messages
     * produced are not changed and should be the same after pure refactorings.
     * 
     * Before you start any changes, execute the program once and save the output to
     * a file:
     * 
     * <p><code>java -cp target/classes com.asdt.farm.App > src/test/resources/output</code></p>
     * 
     * Then, execute the tests while you are performing the changes.
     * 
     * <p><b>Disable this test if you are changing the behaviour of the simulation.</b></p>
     */
    @Test
    public void testSameOutput() {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get("src/test/resources/output"), StandardCharsets.UTF_8)) {
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
        
        Logger.reset();
        Logger.collectInString(true);

        FarmRandom.isfake = true;
        FarmRandom.getInstance().reset();
        (new Simulation()).start(25);

        // assertEquals(fileContent, Logger.getLog());

        try {
            assertReaders(new BufferedReader(new StringReader(fileContent)),
                    new BufferedReader(new StringReader(Logger.getLog())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void assertReaders(BufferedReader expected, BufferedReader actual) throws IOException {
        String expectedLine;
        while ((expectedLine = expected.readLine()) != null) {
            String actualLine = actual.readLine();
            assertNotNull("Expected had more lines then the actual.", actualLine);
            assertEquals(expectedLine, actualLine);
        }
        assertNull("Actual had more lines then the expected.", actual.readLine());
    }
}
