import java.util.regex.Pattern;

public class PasswordTester {

    public static boolean isStrong(String password) {
        boolean isStrong = true;
        if (password.length() < 8) {
            // System.out.println("Notice: Your password has less than 8 characters.");
            isStrong = false;
        }
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            // System.out.println("Notice: Your password does not contain a lower case
            // letter.");
            isStrong = false;
        }
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            // System.out.println("Notice: Your password does not contain an upper case
            // letter.");
            isStrong = false;
        }
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            // System.out.println("Notice: Your password does not contain a number.");
            isStrong = false;
        }
        if (!Pattern.compile("[!@#\\$%\\^&\\*\\(\\)]").matcher(password).find()) {
            // System.out.println("Notice: Your password does not contain a special.");
            isStrong = false;
        }
        if (isStrong) {
            // System.out.println("Result: Strong password.");
        } else {
            // System.out.println("Result: Weak Password.");
        }
        return isStrong;
    }
}
