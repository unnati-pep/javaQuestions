// Count vowels and consonants in string.

import java.util.Scanner;

public class ques64 {

    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;

        str = str.toLowerCase(); // Convert to lowercase for uniformity

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        countVowelsAndConsonants(input);
    }
}
