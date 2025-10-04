import java.util.ArrayList;

// Book class: Independent entity
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Book: " + title + " | Author: " + author);
    }
}

// Library class: Aggregates Book objects
class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book); // Aggregation: Book exists independently
    }

    public void showLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayInfo();
        }
    }
}

// Main class to demonstrate aggregation
public class Q1Aggregation_Library {
    public static void main(String[] args) {
        // Create independent Book objects
        Book book1 = new Book("Fusion Frameworks", "Dr. Rao");
        Book book2 = new Book("Vision Algorithms", "Prof. Mehta");
        Book book3 = new Book("Modular Coding", "Dhruv Jain");

        // Create Library objects
        Library lib1 = new Library("Central Research Library");
        Library lib2 = new Library("Tech Innovation Library");

        // Add books to libraries
        lib1.addBook(book1);
        lib1.addBook(book3);

        lib2.addBook(book2);
        lib2.addBook(book3); // Same book added to multiple libraries

        // Display books in each library
        lib1.showLibraryBooks();
        System.out.println();
        lib2.showLibraryBooks();
    }
}
