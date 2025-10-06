interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    protected void setPrice(double price) { this.price = price; }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount Applied: " + applyDiscount());
        System.out.println("Final Total: " + calculateTotalPrice());
        System.out.println("------------------------------");
    }
}

class VegItem extends FoodItem {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount for Veg Items";
    }
}

class NonVegItem extends FoodItem {
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        double total = (getPrice() * getQuantity()) + (getPrice() * 0.1);
        return total - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.03;
    }

    public String getDiscountDetails() {
        return "3% discount for Non-Veg Items";
    }
}

public class OnlineFoodDelieverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Butter Masala", 250, 2);
        FoodItem item2 = new NonVegItem("Chicken Biryani", 300, 3);

        FoodItem[] order = {item1, item2};

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println(item.getDiscountDetails());
        }
    }
}
