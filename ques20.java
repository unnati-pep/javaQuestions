//Implement quicksort recursively.

import java.util.Arrays;
public class ques20 {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);   // Sort left part
            quickSort(arr, pivotIndex + 1, high);  // Sort right part
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose last element as pivot
        int i = low - 1;        // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high); // Place pivot in correct position
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = { 34, 7, 23, 32, 5, 62 };
        System.out.println("Before sorting: " + Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("After sorting: " + Arrays.toString(data));
    }
}
