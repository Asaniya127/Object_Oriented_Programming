interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.borrower = "";
    }

    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    protected String getBorrower() { return borrower; }
    protected void setBorrower(String borrower) { this.borrower = borrower; }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Reserved: " + (isReserved ? "Yes" : "No"));
        if (isReserved) System.out.println("Borrower: " + borrower);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("---------------------------");
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            borrower = borrowerName;
            System.out.println(title + " reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }

    public abstract int getLoanDuration();
}

class Book extends LibraryItem {
    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }
}

class DVD extends LibraryItem {
    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book("B101", "The Alchemist", "Paulo Coelho");
        LibraryItem item2 = new Magazine("M202", "Time Magazine", "Various");
        LibraryItem item3 = new DVD("D303", "Inception", "Christopher Nolan");

        LibraryItem[] items = {item1, item2, item3};

        item1.reserveItem("Alice");
        item3.reserveItem("Bob");

        for (LibraryItem item : items) {
            item.getItemDetails();
        }
    }
}
