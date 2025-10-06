interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product implements Taxable {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayFinalPrice() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = price + tax - discount;
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: " + price);
        System.out.println(getTaxDetails());
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("---------------------------");
    }
}

class Electronics extends Product {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.1;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "Tax (18%) applied on Electronics";
    }
}

class Clothing extends Product {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "Tax (5%) applied on Clothing";
    }
}

class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    public double calculateTax() {
        return 0;
    }

    public String getTaxDetails() {
        return "No tax applied on Groceries";
    }
}

public class EcommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(201, "Laptop", 60000);
        Product p2 = new Clothing(202, "Jacket", 3000);
        Product p3 = new Groceries(203, "Rice Bag", 1500);

        Product[] products = {p1, p2, p3};
        for (Product p : products) {
            p.displayFinalPrice();
        }
    }
}
