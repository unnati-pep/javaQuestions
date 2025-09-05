// Simple hotel reservation system in console.

import java.util.Scanner;

public class ques76
{
    static boolean[] rooms = new boolean[10]; // false = available, true = booked

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAvailableRooms();
                    break;
                case 2:
                    bookRoom(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the hotel reservation system.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    static void showMenu() {
        System.out.println("=== Hotel Reservation System ===");
        System.out.println("1. Show Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. Cancel a Booking");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    static void showAvailableRooms() {
        System.out.println("Available Rooms:");
        boolean anyAvailable = false;
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i]) {
                System.out.println("Room " + (i + 1));
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms available.");
        }
    }

    static void bookRoom(Scanner scanner) {
        System.out.print("Enter room number to book (1-10): ");
        int roomNumber = scanner.nextInt();

        if (roomNumber < 1 || roomNumber > 10) {
            System.out.println("Invalid room number.");
        } else if (rooms[roomNumber - 1]) {
            System.out.println("Room already booked.");
        } else {
            rooms[roomNumber - 1] = true;
            System.out.println("Room " + roomNumber + " booked successfully.");
        }
    }

    static void cancelBooking(Scanner scanner) {
        System.out.print("Enter room number to cancel (1-10): ");
        int roomNumber = scanner.nextInt();

        if (roomNumber < 1 || roomNumber > 10) {
            System.out.println("Invalid room number.");
        } else if (!rooms[roomNumber - 1]) {
            System.out.println("Room is not booked.");
        } else {
            rooms[roomNumber - 1] = false;
            System.out.println("Booking for Room " + roomNumber + " cancelled.");
        }
    }
}
