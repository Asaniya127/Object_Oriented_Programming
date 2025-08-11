// Program to Model a Movie Ticket Booking System

class Movie {
    String movieName;
    String seatNumber;
    double price;

    // Method to book a ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display ticket details
    void displayTicketDetails() {
        System.out.println("----- Ticket Details -----");
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("--------------------------");
    }
}

public class MovieTicket {
    public static void main(String[] args) {
        // Create a MovieTicket object
        Movie ticket1 = new Movie();

        // Book a ticket
        ticket1.bookTicket("Inception", "A12", 250);

        // Display ticket details
        ticket1.displayTicketDetails();

        // Another ticket
        Movie ticket2 = new Movie();
        ticket2.bookTicket("Avengers: Endgame", "B5", 300);
        ticket2.displayTicketDetails();
    }
}
