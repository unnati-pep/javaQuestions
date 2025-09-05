// validity of phone numbers using regex

import java.util.Scanner;
import java.util.regex.*;

public class ques52 {

    public static boolean isValidPhoneNumber(String number) {
        // Regex to match common phone number formats
        String regex = "^(\\+\\d{1,3}\\s?)?\\(?\\d{3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a phone number to validate:");
        String input = scanner.nextLine();

        if (isValidPhoneNumber(input)) {
            System.out.println("✅ Valid phone number.");
        } else {
            System.out.println("❌ Invalid phone number.");
        }

        scanner.close();
    }
}
