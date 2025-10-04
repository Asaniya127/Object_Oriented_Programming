import java.util.ArrayList;

// Product class: independent entity
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Product: " + name + " | Price: ₹" + price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Order class: aggregates products, associated with a customer
class Order {
    private String orderId;
    private ArrayList<Product> products;
    private Customer customer;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product); // Aggregation
    }

    public void viewOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        System.out.println("Products in Order:");
        for (Product p : products) {
            p.displayInfo();
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}

// Customer class: places orders
class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Order placeOrder(String orderId) {
        Order newOrder = new Order(orderId, this);
        orders.add(newOrder);
        return newOrder;
    }

    public void viewOrders() {
        System.out.println("Customer: " + name + " | Orders:");
        for (Order o : orders) {
            o.viewOrderDetails();
            System.out.println("Total: ₹" + o.calculateTotal());
            System.out.println();
        }
    }
}

// Main class to demonstrate the system
public class Q4ECommerce {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 75000);
        Product mouse = new Product("Wireless Mouse", 1500);
        Product keyboard = new Product("Mechanical Keyboard", 3500);

        // Create customer
        Customer dhruv = new Customer("Dhruv Jain");

        // Place orders
        Order order1 = dhruv.placeOrder("ORD001");
        order1.addProduct(laptop);
        order1.addProduct(mouse);

        Order order2 = dhruv.placeOrder("ORD002");
        order2.addProduct(keyboard);

        // View all orders
        dhruv.viewOrders();
    }
}
