// Tower of Hanoi problem.

//Only one disk can be moved at a time.
//A larger disk cannot be placed on top of a smaller disk.
//Only the top disk of a rod can be moved.

import java.util.Scanner;

public class ques79 {
    static int stepCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of disks from user
        System.out.print("Enter number of disks: ");
        int n = scanner.nextInt();

        System.out.println("Steps to solve Tower of Hanoi:");
        solveHanoi(n, 'A', 'C', 'B'); // A = source, C = destination, B = auxiliary

        System.out.println("Total steps required: " + stepCount);
    }

    // Recursive method to solve Tower of Hanoi
    public static void solveHanoi(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            stepCount++;
            return;
        }

        solveHanoi(n - 1, source, auxiliary, destination);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        stepCount++;
        solveHanoi(n - 1, auxiliary, destination, source);
    }
}
