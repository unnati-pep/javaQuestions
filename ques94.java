// Check Armstrong numbers in given range.

import java.util.Scanner;

public class ques94 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take range input from user
        System.out.print("Enter start of range: ");
        int start = scanner.nextInt();
        System.out.print("Enter end of range: ");
        int end = scanner.nextInt();
        boolean found = false;
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");

        for (int num = start; num <= end; num++) {
            if (isArmstrong(num)) {
                System.out.println(num);
                found=true;
            }
        }
        if(!found){
            System.out.println("No armstrong numbers in the given range.");
        }
    }

    // Method to check if a number is Armstrong
    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == original;
    }
}
