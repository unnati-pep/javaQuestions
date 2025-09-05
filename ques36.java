import java.util.Scanner;

public class ques36 {
    public static void main(String[] args) {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a sentence
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();  // Read the entire line

        // Call the method to reverse words in the sentence
        String reversedSentence = reverseWords(sentence);

        // Print the reversed sentence
        System.out.println("Reversed sentence: " + reversedSentence);

        // Close the scanner
        scanner.close();
    }

    public static String reverseWords(String sentence) {
        // Handle empty sentence
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        StringBuilder reversed = new StringBuilder();
        int end = sentence.length();

        for (int i = sentence.length() - 1; i >= 0; i--) {
            // When a space is encountered, reverse the word before the space
            if (sentence.charAt(i) == ' ') {
                if (i < end - 1) {
                    reversed.append(sentence, i + 1, end).append(' ');
                }
                end = i;
            }
        }

        // Append the last word (since it doesn't end with a space)
        reversed.append(sentence, 0, end);

        return reversed.toString();
    }
}
