// Find longest substring without repeating characters

import java.util.*;

public class ques66 {

    public static String findLongestUniqueSubstring(String str) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLength = 0, startIndex = 0;

        for (int right = 0; right < str.length(); right++) {
            char ch = str.charAt(right);

            while (seen.contains(ch)) {
                seen.remove(str.charAt(left));
                left++;
            }

            seen.add(ch);

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }

        return str.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = findLongestUniqueSubstring(input);
        System.out.println("Longest substring without repeating characters: " + result);
    }
}
