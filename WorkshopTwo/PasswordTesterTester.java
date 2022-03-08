// https://code.visualstudio.com/docs/java/java-testing

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

public class PasswordTesterTester {

    @Test
    public void runMyPasswords() {
        try {
            Scanner passwordScanner = new Scanner(
                    new File("C:\\Users\\bryce\\Documents\\University\\SENG3320 - V&V\\WorkshopTwo\\Passwords.txt"));
            int iter = 0;
            while (passwordScanner.hasNext()) {
                iter++;

                String[] qr = passwordScanner.nextLine().split(" ");

                System.out.print("Test case [" + iter + "] : " + qr[0] + " is " + qr[1]);
                if (MyPasswordTester.isStrong(qr[0]) != (qr[1].equals("strong")))
                    System.out.println(" - FAIL");
                else
                    System.out.println(" - PASS");

                // Actually perform the test case... (The rest of this is either debugging or
                // getting the input from the file)
                assertEquals("Test case " + iter + ": " + qr[0] + " is " + qr[1] + " failed!",
                        MyPasswordTester.isStrong(qr[0]),
                        (qr[1].equals("strong")));

            }
            passwordScanner.close();

        } catch (Exception e) {
            assertEquals(e.getStackTrace().toString(), 0, 1);
        }
    }

    @Test
    public void runPasswords() {
        try {
            Scanner passwordScanner = new Scanner(
                    new File("C:\\Users\\bryce\\Documents\\University\\SENG3320 - V&V\\WorkshopTwo\\Passwords.txt"));
            int iter = 0;
            while (passwordScanner.hasNext()) {
                iter++;

                String[] qr = passwordScanner.nextLine().split(" ");

                System.out.print("Test case [" + iter + "] : " + qr[0] + " is " + qr[1]);
                if (PasswordTester.isStrong(qr[0]) != (qr[1].equals("strong")))
                    System.out.println(" - FAIL");
                else
                    System.out.println(" - PASS");

                // Actually perform the test case... (The rest of this is either debugging or
                // getting the input from the file)
                assertEquals("Test case " + iter + ": " + qr[0] + " is " + qr[1] + " failed!",
                        PasswordTester.isStrong(qr[0]),
                        (qr[1].equals("strong")));

            }
            passwordScanner.close();

        } catch (Exception e) {
            assertEquals(e.getStackTrace().toString(), 0, 1);
        }
    }
}