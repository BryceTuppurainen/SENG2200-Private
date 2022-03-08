public class MyPasswordTester {

    // False infers weak password
    public static boolean isStrong(String password) {
        boolean strong = true;
        if (password.length() < 8) {
            // System.out.println(password + " - Too short...");
            strong = false;
        }
        if (!password.matches(".*[a-z]+.*")) {
            // System.out.println(password + " - No lower case characters...");
            strong = false;
        }
        if (!password.matches(".*[A-Z]+.*")) {
            // System.out.println(password + " - No upper case characters...");
            strong = false;
        }
        if (!password.matches(".*[0-9]+.*")) {
            // System.out.println(password + " - No numbers...");
            strong = false;
        }
        if (!password.matches(".*[!@#$%^&*()]+.*")) {
            // System.out.println(password + " - No special character...");
            strong = false;
        }
        return strong;
    }
}