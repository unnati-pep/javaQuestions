//Calculate age from DOB using java.time.

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
public class ques25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for DOB
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dobInput = scanner.nextLine();

        // Convert input to LocalDate
        LocalDate dob = LocalDate.parse(dobInput);
        LocalDate today = LocalDate.now();

        // Calculate age
        Period age = Period.between(dob, today);


        System.out.println("You are " + age.getYears() + " years, " +
                age.getMonths() + " months, and " +
                age.getDays() + " days old.");
    }

}

