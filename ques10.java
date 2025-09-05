// Regex program to extract email IDs from text.

import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class ques10 {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();

        // Regex pattern for matching email addresses
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text containing email addresses:");
        String input = scanner.nextLine();

        List<String> emailList = extractEmails(input);

        if (emailList.isEmpty()) {
            System.out.println("No email addresses found.");
        } else {
            System.out.println("Extracted email addresses:");
            for (String email : emailList) {
                System.out.println(email);
            }
        }
    }
}
