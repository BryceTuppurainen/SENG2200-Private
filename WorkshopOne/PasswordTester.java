import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordTester {

    private String password;

    public static void main(String args[]) {
        System.out.println("");
        PasswordTester passwordTester = new PasswordTester();
        boolean fail = false;
        try {
            Scanner passwordScanner = new Scanner(new File("passwords.txt"));
            while (passwordScanner.hasNext()) {
                String[] qr = passwordScanner.nextLine().split(" ");
                passwordTester.setPassword(qr[0]);
                if (passwordTester.isStrong()) {
                    System.out.print(passwordTester.getPassword() + " strong");
                    if (qr[1].equals("strong"))
                        System.out.println(" - PASS");
                    else {
                        System.out.println(" - FAIL Expected weak");
                        fail = true;
                    }
                } else {
                    System.out.print(passwordTester.getPassword() + " weak");
                    if (qr[1].equals("weak"))
                        System.out.println(" - PASS");
                    else {
                        System.out.println(" - FAIL Expected strong");
                        fail = true;
                    }
                }
            }

            if (fail == false)
                System.out.println("\n---ALL TESTS PASSED WITH EXPECTED VALUES---");
            else
                System.out.println("\n---A TEST FAILED---");
            passwordScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println("");
        System.out.print("Try a password > ");
        Scanner console = new Scanner(System.in);
        passwordTester.setPassword(console.nextLine());
        if (passwordTester.isStrong())
            System.out.println("Strong");
        else
            System.out.println("Weak");
        console.close();
        System.out.println("");
    }

    PasswordTester() {
        password = "";
    }

    PasswordTester(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    // False infers weak password is set
    public boolean isStrong() {
        boolean strong = true;
        if (password.length() < 8) {
            System.out.println(password + " - Too short...");
            strong = false;
        }
        if (!password.matches(".*[a-z]+.*")) {
            System.out.println(password + " - No lower case characters...");
            strong = false;
        }
        if (!password.matches(".*[A-Z]+.*")) {
            System.out.println(password + " - No upper case characters...");
            strong = false;
        }
        if (!password.matches(".*[0-9]+.*")) {
            System.out.println(password + " - No numbers...");
            strong = false;
        }
        if (!password.matches(".*[!@#$%^&*()]+.*")) {
            System.out.println(password + " - No special character...");
            strong = false;
        }
        return strong;
    }
}