import java.util.Scanner;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;

    public TicketReservationSystem() {
        last = null;
    }

    // Add new ticket (at the end)
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (last == null) {
            last = newTicket;
            last.next = last; // Circular link
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove a ticket by ID
    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = last.next, prev = last;
        boolean found = false;

        do {
            if (current.ticketID == ticketID) {
                found = true;
                if (current == last.next && current == last) { // Only one ticket
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) last = prev; // If deleting last node
                }
                System.out.println("Ticket " + ticketID + " canceled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        if (!found) System.out.println("Ticket ID not found.");
    }

    // Search ticket by Customer Name or Movie Name
    public void searchTicket(String key) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = last.next;
        boolean found = false;

        do {
            if (current.customerName.equalsIgnoreCase(key) || current.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != last.next);

        if (!found) System.out.println("No tickets found for: " + key);
    }

    // Display all tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = last.next;
        System.out.println("\nBooked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    // Count total booked tickets
    public int countTickets() {
        if (last == null) return 0;
        int count = 0;
        Ticket current = last.next;
        do {
            count++;
            current = current.next;
        } while (current != last.next);
        return count;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Avatar 2", "A1", "6:30 PM");
        system.addTicket(102, "Bob", "Batman", "B5", "7:00 PM");
        system.addTicket(103, "Charlie", "Avatar 2", "A2", "6:30 PM");

        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());

        System.out.println("\nSearching for 'Avatar 2':");
        system.searchTicket("Avatar 2");

        System.out.println("\nCancelling Ticket 102...");
        system.removeTicket(102);

        system.displayTickets();
        System.out.println("\nTotal Tickets: " + system.countTickets());
    }
}
