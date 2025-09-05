import java.util.Scanner;

public class ques30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Binary to Decimal
        System.out.print("Enter a binary number: ");
        String binaryInput = scanner.nextLine();
        int decimalOutput = Integer.parseInt(binaryInput, 2);
        System.out.println("Decimal equivalent: " + decimalOutput);

        // Decimal to Binary
        System.out.print("Enter a decimal number: ");
        int decimalInput = scanner.nextInt();
        String binaryOutput = Integer.toBinaryString(decimalInput);
        System.out.println("Binary equivalent: " + binaryOutput);
    }
}
