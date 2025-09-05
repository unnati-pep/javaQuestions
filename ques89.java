import java.util.Scanner;
import java.util.regex.*;
import java.util.*;

public class ques89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a sentence with hashtags: ");
        String inputText = scanner.nextLine();

        // Regex pattern to find hashtags
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(inputText);

        List<String> hashtags = new ArrayList<>();

        while (matcher.find()) {
            hashtags.add(matcher.group());
        }

        // Output the found hashtags
        if (hashtags.isEmpty()) {
            System.out.println("No hashtags found.");
        } else {
            System.out.println("Found hashtags: " + hashtags);
        }
    }
}
