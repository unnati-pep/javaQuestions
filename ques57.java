// Check if two strings are anagrams.
import java.util.Arrays;
import java.util.Scanner;

public class ques57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        boolean isAnagram = areAnagrams(str1, str2);
        System.out.println("Are the two strings anagrams? " + (isAnagram ? "Yes" : "No"));

        scanner.close();
    }

    static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        Arrays.sort(a1);
        Arrays.sort(a2);

        return Arrays.equals(a1, a2);
    }
}
