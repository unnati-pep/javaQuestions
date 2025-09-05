// Find missing number in array sequence.

import java.util.Scanner;

public class ques56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Missing one number, so size is n-1
        System.out.print("Enter the value of N (sequence from 1 to N): ");
        int n = scanner.nextInt();

        int[] arr = new int[n - 1];
        System.out.println("Enter " + (n - 1) + " elements of the sequence (missing one number):");
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        int expectedSum = n * (n + 1) / 2;
        int missing = expectedSum - sum;

        System.out.println("Missing number is: " + missing);

        scanner.close();
    }
}
