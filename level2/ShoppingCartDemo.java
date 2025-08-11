import java.util.ArrayList;
import java.util.List;

class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return itemName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalPrice();
    }
}

class ShoppingCart {
    private List<CartItem> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity) {
        cart.add(new CartItem(itemName, price, quantity));
        System.out.println(itemName + " added to cart.");
    }

    public void removeItem(String itemName) {
        boolean removed = cart.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
        if (removed) {
            System.out.println(itemName + " removed from cart.");
        } else {
            System.out.println(itemName + " not found in cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0;
        System.out.println("\nCart Summary:");
        for (CartItem item : cart) {
            System.out.println(item);
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: ₹" + total);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 55000, 1);
        cart.addItem("Mouse", 500, 2);
        cart.addItem("Notebook", 50, 5);

        cart.displayTotalCost();

        cart.removeItem("Mouse");
        cart.displayTotalCost();
    }
}