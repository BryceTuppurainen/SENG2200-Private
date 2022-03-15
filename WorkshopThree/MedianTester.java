// https://code.visualstudio.com/docs/java/java-testing

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MedianTester {

    @Test
    public void runMedians() {
        int passes = 0, total = 0;
        try {
            Scanner tests = new Scanner(new File(
                    "C:\\Users\\bryce\\Documents\\University\\SENG3320 - V&V\\WorkshopThree\\MedianTests.txt"));
            Scanner results = new Scanner(new File(
                    "C:\\Users\\bryce\\Documents\\University\\SENG3320 - V&V\\WorkshopThree\\MedianResults.txt"));
            while (tests.hasNextLine()) {
                String vals[] = tests.nextLine().split(" ");
                int result = Integer.parseInt(results.nextLine());
                int x = Integer.parseInt(vals[0]);
                int y = Integer.parseInt(vals[1]);
                int z = Integer.parseInt(vals[2]);

                System.out.println("\nTESTING - " + x + " " + y + " " + z + " " + " = Median: " + result);

                try {
                    assertEquals(result, Median.median(x, y, z));
                    System.out.println("PASS - Expected Median: " + result + " and was: " + Median.median(x, y, z));
                } catch (AssertionError e) {
                    passes--;
                    System.out.println("FAIL - Expected Median: " + result + " but was: " + Median.median(x, y, z));
                }
                passes++;
                total++;
            }
            results.close();
            tests.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertEquals("There was an issue with the tester! MedianTests.txt and MedianResults.txt not found!", 0, 1);
        } catch (Exception e) {
            e.printStackTrace();
            assertEquals("There was an issue with the tester!", 0, 1);
        }
        if (passes != total) {
            System.out.println("\nFAIL - " + passes + " of " + total + " tests passed!");
            fail();
        }
        System.out.println("\nPASS - All " + passes + " tests passed!");
    }
}
