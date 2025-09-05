import java.util.*;

abstract class Employee {
    protected String name;
    protected int id;
    protected double baseSalary;

    public Employee(String name, int id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + calculateSalary());
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    private int overtimeHours;
    private double hourlyRate;

    public Developer(String name, int id, double baseSalary, int overtimeHours, double hourlyRate) {
        super(name, id, baseSalary);
        this.overtimeHours = overtimeHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (overtimeHours * hourlyRate);
    }
}

public class ques96 {
    private List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice;
        do {
            System.out.println("\n=== Payroll System Menu ===");
            System.out.println("1. Add Manager");
            System.out.println("2. Add Developer");
            System.out.println("3. View Payroll");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1:
                    addManager();
                    break;
                case 2:
                    addDeveloper();
                    break;
                case 3:
                    viewPayroll();
                    break;
                case 4:
                    System.out.println("Exiting Payroll System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    private void addManager() {
        System.out.print("Enter Manager Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = getIntInput();

        System.out.print("Enter Base Salary: ");
        double salary = getDoubleInput();

        System.out.print("Enter Bonus: ");
        double bonus = getDoubleInput();

        Manager manager = new Manager(name, id, salary, bonus);
        employees.add(manager);
        System.out.println("Manager added successfully.");
    }

    private void addDeveloper() {
        System.out.print("Enter Developer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter ID: ");
        int id = getIntInput();

        System.out.print("Enter Base Salary: ");
        double salary = getDoubleInput();

        System.out.print("Enter Overtime Hours: ");
        int hours = getIntInput();

        System.out.print("Enter Hourly Rate: ");
        double rate = getDoubleInput();

        Developer developer = new Developer(name, id, salary, hours, rate);
        employees.add(developer);
        System.out.println("Developer added successfully.");
    }

    private void viewPayroll() {
        if (employees.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("\nPayroll Details:");
            for (Employee e : employees) {
                e.displayInfo();
            }
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private double getDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid decimal number: ");
            }
        }
    }

    public static void main(String[] args) {
        ques96 system = new ques96();
        system.start();
    }
}
