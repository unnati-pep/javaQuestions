//Validate strong passwords with regex.


import java.util.Scanner;
import java.util.regex.*;

public class ques31 {

    public static boolean isStrongPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!*_-])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to validate(Must be at least 8 characters long and include uppercase, lowercase, digit, and special character): ");
        String password = scanner.nextLine();

        if (isStrongPassword(password)) {
            System.out.println("✅ Strong password.");
        } else {
            System.out.println("❌ Weak password. Must be at least 8 characters long and include uppercase, lowercase, digit, and special character.");
        }
    }
}
