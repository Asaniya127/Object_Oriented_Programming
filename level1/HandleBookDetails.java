// Book.java
import java.util.Scanner;

class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("---- Book Details ----");
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : ₹" + price);
    }
}

public class HandleBookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking book details from user
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Book Price: ");
        double price = sc.nextDouble();

        // Creating Book object
        Book book = new Book(title, author, price);

        // Displaying book details
        book.displayDetails();

        sc.close();
    }
}
