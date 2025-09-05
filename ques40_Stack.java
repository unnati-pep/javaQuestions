import java.util.Scanner;

public class ques40_Stack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack with a given capacity
    public ques40_Stack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed to stack.");
        }
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Peek method to view the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to display the current elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // Main method to interact with the stack using user input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the stack size
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();

        // Create a stack with the given size
        ques40_Stack stack = new ques40_Stack(size);

        // Loop to keep asking the user for an operation until they exit
        while (true) {
            // Display the menu to the user
            System.out.println("\nChoose operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            // Switch statement to perform the corresponding operation
            switch (choice) {
                case 1 -> { // Push operation
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                }
                case 2 -> { // Pop operation
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped: " + popped);
                    }
                }
                case 3 -> { // Peek operation
                    int top = stack.peek();
                    if (top != -1) {
                        System.out.println("Top element: " + top);
                    }
                }
                case 4 -> stack.display(); // Display operation
                case 5 -> { // Exit operation
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again."); // Invalid choice
            }
        }
    }
}
