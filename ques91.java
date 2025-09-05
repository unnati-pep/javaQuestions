// Count palindromes in a text file.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ques91 {
    public static void main(String[] args) {
        String filePath = "src/forPalindromes"; // Replace with your actual file path
        int count = 0;

        System.out.println("Palindromes found in the file:");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split by non-word characters

                for (String word : words) {
                    if (!word.isEmpty() && isPalindrome(word)) {
                        System.out.println(word);
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println("No palindromes found in the file.");
            } else {
                System.out.println("Total palindromes: " + count);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Check if a word is a palindrome
    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0, right = word.length() - 1;

        while (left < right) {
            if (word.charAt(left++) != word.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
