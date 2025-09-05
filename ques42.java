//Simple calculator using switch expressions.

import java.util.Scanner;

public class ques42 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get two numbers from the user
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Get the operator from the user
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Switch expression to perform the calculation based on the operator
        double result = switch (operator) {
            case '+' -> num1 + num2;  // Addition
            case '-' -> num1 - num2;  // Subtraction
            case '*' -> num1 * num2;  // Multiplication
            case '/' -> {
                // Check for division by zero
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    yield Double.NaN; // Return NaN if division by zero
                } else {
                    yield num1 / num2;  // Division
                }
            }
            default -> {
                System.out.println("Invalid operator! Please use one of +, -, *, /");
                yield Double.NaN;  // Return NaN for invalid operator
            }
        };

        // Output the result if it's a valid calculation
        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }
    }
}
