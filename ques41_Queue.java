//Implement queue from scratch.

import java.util.Scanner;

public class ques41_Queue {
    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue with a given capacity
    public ques41_Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue method to add an element to the rear of the queue
    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
            System.out.println(value + " enqueued to queue.");
        }
    }

    // Dequeue method to remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        } else {
            int value = queue[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }
    }

    // Peek method to view the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queue[front];
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check the size of the queue
    public int size() {
        return size;
    }

    // Display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    // Main method for interactive queue operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the queue size
        System.out.print("Enter queue size: ");
        int size = scanner.nextInt();

        // Create a queue with the specified size
        ques41_Queue queue = new ques41_Queue(size);

        // Loop to keep asking the user for an operation until they exit
        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            // Switch statement to perform the corresponding operation
            switch (choice) {
                case 1 -> { // Enqueue operation
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                }
                case 2 -> { // Dequeue operation
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued: " + dequeued);
                    }
                }
                case 3 -> { // Peek operation
                    int front = queue.peek();
                    if (front != -1) {
                        System.out.println("Front element: " + front);
                    }
                }
                case 4 -> queue.display(); // Display operation
                case 5 -> { // Exit operation
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again."); // Invalid choice
            }
        }
    }
}

