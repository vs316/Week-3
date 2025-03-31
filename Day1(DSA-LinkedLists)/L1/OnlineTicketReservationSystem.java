package DSA.LinkedLists;

class TicketNode {
    String ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private TicketNode head;
    private TicketNode tail;

    public TicketReservationSystem() {
        head = null;
        tail = null;
    }

    // Add a new ticket at the end of the circular list.
    public void addTicketAtEnd(String ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) { // Empty list: new node becomes head and tail.
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;  // Make it circular.
        } else {
            tail.next = newTicket;  // Append at the end.
            tail = newTicket;
            tail.next = head;       // Maintain circularity.
        }
        System.out.println("Added ticket with ID: " + ticketId);
    }

    // Remove a ticket by Ticket ID.
    public void removeTicketById(String ticketId) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        TicketNode current = head;
        TicketNode previous = tail; // In a circular list, previous of head is tail.
        boolean found = false;

        // Traverse until we loop back to head.
        do {
            if (current.ticketId.equals(ticketId)) {
                found = true;
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket with ID " + ticketId + " not found.");
            return;
        }

        // Handling removal when only one node exists.
        if (current == head && head == tail) {
            head = null;
            tail = null;
        } else {
            // If removing head, move head pointer.
            if (current == head) {
                head = head.next;
                tail.next = head;
            }
            // If removing tail, update tail pointer.
            else if (current == tail) {
                tail = previous;
                tail.next = head;
            }
            // Else, bypass the current node.
            else {
                previous.next = current.next;
            }
        }
        System.out.println("Removed ticket with ID: " + ticketId);
    }

    // Display all tickets in the circular list.
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }
        System.out.println("Ticket Reservations:");
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + " | Customer: " + temp.customerName +
                    " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber +
                    " | Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name.
    // Either parameter may be provided; if one is null, the search is done on the other.
    public void searchTicket(String customerName, String movieName) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        boolean found = false;
        TicketNode temp = head;
        do {
            if ((customerName != null && temp.customerName.equalsIgnoreCase(customerName)) ||
                    (movieName != null && temp.movieName.equalsIgnoreCase(movieName))) {
                System.out.println("Found Ticket => Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found matching the criteria.");
        }
    }

    // Calculate the total number of booked tickets.
    public int countTickets() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        TicketReservationSystem ticketSystem = new TicketReservationSystem();

        // Add several ticket reservations.
        ticketSystem.addTicketAtEnd("T001", "Alice", "Inception", "A10", "09:30 AM");
        ticketSystem.addTicketAtEnd("T002", "Bob", "Avatar", "B15", "10:00 AM");
        ticketSystem.addTicketAtEnd("T003", "Charlie", "Inception", "C20", "10:30 AM");
        ticketSystem.addTicketAtEnd("T004", "Diana", "Interstellar", "D25", "11:00 AM");

        // Display current ticket reservations.
        System.out.println();
        ticketSystem.displayTickets();

        // Search for a ticket by customer name.
        System.out.println("\nSearching tickets by customer 'Alice':");
        ticketSystem.searchTicket("Alice", null);

        // Search for a ticket by movie name.
        System.out.println("\nSearching tickets for movie 'Inception':");
        ticketSystem.searchTicket(null, "Inception");

        // Remove a ticket and display the updated list.
        System.out.println("\nRemoving ticket with ID T002:");
        ticketSystem.removeTicketById("T002");
        System.out.println();
        ticketSystem.displayTickets();

        // Display total number of booked tickets.
        System.out.println("\nTotal booked tickets: " + ticketSystem.countTickets());
    }
}