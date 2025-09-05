// Generate Pascal’s triangle.

import java.util.Scanner;

public class ques95 {

    // Function to generate Pascal's Triangle up to a given number of rows
    public static void generatePascalsTriangle(int rows) {
        // Loop through each row
        for (int i = 0; i < rows; i++) {
            int num = 1;  // The first element in each row is always 1

            // Print leading spaces to make the triangle centered
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            // Print the elements of each row
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);  // Calculate the next number in the row
            }

            // Move to the next line after each row
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of rows
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int rows = scanner.nextInt();

        // Call the function to generate Pascal's Triangle
        generatePascalsTriangle(rows);
    }
}
