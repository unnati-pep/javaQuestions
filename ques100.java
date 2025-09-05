// flight booking console

import java.util.*;

public class ques100 {

    static Scanner scanner = new Scanner(System.in);

    // Flight class to hold flight info
    static class Flight {
        String flightNumber;
        String origin;
        String destination;
        int totalSeats;
        int availableSeats;
        double price;

        public Flight(String flightNumber, String origin, String destination, int totalSeats, double price) {
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.totalSeats = totalSeats;
            this.availableSeats = totalSeats;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("%s | %s -> %s | Price: $%.2f | Available Seats: %d",
                    flightNumber, origin, destination, price, availableSeats);
        }
    }

    // Booking class to hold booking info
    static class Booking {
        String bookingId;
        Flight flight;
        String passengerName;
        int seatsBooked;

        public Booking(String bookingId, Flight flight, String passengerName, int seatsBooked) {
            this.bookingId = bookingId;
            this.flight = flight;
            this.passengerName = passengerName;
            this.seatsBooked = seatsBooked;
        }

        @Override
        public String toString() {
            return String.format("Booking ID: %s | Passenger: %s | Flight: %s | Seats: %d",
                    bookingId, passengerName, flight.flightNumber, seatsBooked);
        }
    }

    static Map<String, Flight> flights = new HashMap<>();
    static Map<String, Booking> bookings = new HashMap<>();

    public static void main(String[] args) {
        initializeFlights();

        while (true) {
            System.out.println("\n===== Flight Reservation System =====");
            System.out.println("1. View All Flights");
            System.out.println("2. Search Flights");
            System.out.println("3. Book a Flight");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View My Bookings");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAllFlights();
                    break;
                case 2:
                    searchFlights();
                    break;
                case 3:
                    bookFlight();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    viewBookings();
                    break;
                case 6:
                    System.out.println("Thank you for using the Flight Reservation System.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }

    static void initializeFlights() {
        flights.put("F101", new Flight("F101", "New York", "Los Angeles", 100, 299.99));
        flights.put("F102", new Flight("F102", "Chicago", "Miami", 80, 199.99));
        flights.put("F103", new Flight("F103", "San Francisco", "Seattle", 50, 149.99));
        flights.put("F104", new Flight("F104", "Dallas", "New York", 90, 249.99));
        flights.put("F105", new Flight("F105", "Miami", "Chicago", 70, 179.99));
    }

    static void viewAllFlights() {
        System.out.println("\nAvailable Flights:");
        flights.values().forEach(System.out::println);
    }

    static void searchFlights() {
        System.out.print("Enter origin city: ");
        String origin = scanner.nextLine().trim();

        System.out.print("Enter destination city: ");
        String destination = scanner.nextLine().trim();

        List<Flight> results = new ArrayList<>();
        for (Flight f : flights.values()) {
            if (f.origin.equalsIgnoreCase(origin) && f.destination.equalsIgnoreCase(destination)) {
                results.add(f);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No flights found from " + origin + " to " + destination);
        } else {
            System.out.println("\nSearch Results:");
            results.forEach(System.out::println);
        }
    }

    static void bookFlight() {
        System.out.print("Enter flight number to book: ");
        String flightNum = scanner.nextLine().trim();

        Flight flight = flights.get(flightNum);
        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }

        System.out.println("Flight selected: " + flight);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter number of seats to book: ");
        int seats = getIntInput();

        if (seats <= 0) {
            System.out.println("Number of seats must be positive.");
            return;
        }

        if (flight.availableSeats < seats) {
            System.out.println("Not enough seats available.");
            return;
        }

        flight.availableSeats -= seats;

        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, flight, name, seats);
        bookings.put(bookingId, booking);

        System.out.println("Booking successful! Your booking ID is: " + bookingId);
    }

    static void cancelBooking() {
        System.out.print("Enter your booking ID to cancel: ");
        String bookingId = scanner.nextLine().trim();

        Booking booking = bookings.get(bookingId);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        booking.flight.availableSeats += booking.seatsBooked;
        bookings.remove(bookingId);

        System.out.println("Booking " + bookingId + " cancelled successfully.");
    }

    static void viewBookings() {
        System.out.print("Enter your name to view bookings: ");
        String name = scanner.nextLine().trim();

        boolean found = false;
        for (Booking b : bookings.values()) {
            if (b.passengerName.equalsIgnoreCase(name)) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No bookings found for " + name);
        }
    }

    // Generate a simple random booking ID
    static String generateBookingId() {
        return "BKG" + new Random().nextInt(10000);
    }

    // Safe integer input reading
    static int getIntInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
