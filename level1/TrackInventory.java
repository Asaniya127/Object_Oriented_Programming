// Item.java
import java.util.Scanner;

class Item {
    // Attributes
    int itemCode;
    String itemName;
    double price;

    // Constructor
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost for given quantity
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    void displayDetails() {
        System.out.println("---- Item Details ----");
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : ₹" + price);
    }
}

public class TrackInventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking item details from user
        System.out.print("Enter Item Code: ");
        int code = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Item Price: ");
        double price = sc.nextDouble();

        // Creating Item object
        Item item = new Item(code, name, price);

        // Displaying item details
        item.displayDetails();

        // Taking quantity to calculate total cost
        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Total Cost for " + quantity + " units: ₹" + totalCost);

        sc.close();
    }
}
