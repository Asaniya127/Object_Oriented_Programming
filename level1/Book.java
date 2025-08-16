package JavaConstructors.Level1;

import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this("Unknown", "Unknown", 0.0);
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Book b = new Book(title, author, price);
        b.display();
    }
}
