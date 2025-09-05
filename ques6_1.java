import java.util.Scanner;

public class ques6_1 {
    public static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number:");
        int f=sc.nextInt();
        System.out.println("Fibonacci: " + fib(f));
    }
}
