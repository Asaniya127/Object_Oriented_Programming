// Program to Handle Mobile Phone Details

class MobilePhone {
    String brand;
    String model;
    double price;

    // Constructor to initialize attributes
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
    }
}

public class HandleMobileDetails {
    public static void main(String[] args) {
        // Creating objects
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S24", 79999);
        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 15 Pro", 129900);

        System.out.println("Phone 1 Details:");
        phone1.displayDetails();

        System.out.println("\nPhone 2 Details:");
        phone2.displayDetails();
    }
}
