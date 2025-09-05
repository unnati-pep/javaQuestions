// Rotate an array k times.
import java.util.Scanner;
import java.util.Arrays;

public class ques54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array
        System.out.print("Enter number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input k
        System.out.print("Enter number of rotations (K): ");
        int k = scanner.nextInt();
        k = k % n;

        // Rotate array (right rotation)
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);

        System.out.println("Rotated array: " + Arrays.toString(arr));
        scanner.close();
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
