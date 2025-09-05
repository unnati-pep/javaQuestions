// Use switch expression to classify grades.


import java.util.Scanner;

public class ques7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take grade input from user
        System.out.print("Enter your grade (A, B, C, D, F): ");
        String grade = scanner.nextLine().toUpperCase();

        // Switch expression to classify grade
        String result = switch (grade) {
            case "A" -> "Excellent";
            case "B" -> "Good";
            case "C" -> "Average";
            case "D" -> "Below Average";
            case "F" -> "Fail";
            default -> "Invalid grade entered";
        };

        System.out.println("Performance: " + result);
    }
}
