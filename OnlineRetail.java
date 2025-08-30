
class Order {
    int orderId;
    String orderDate;
    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }

    String getOrderStatus() {
        return "Order placed";
    }
}
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " + trackingNumber);
    }

    @Override
    String getOrderStatus() {
        return "Order shipped";
    }
}

// Subclass 2
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " + deliveryDate);
    }

    @Override
    String getOrderStatus() {
        return "Order delivered";
    }
}
public class OnlineRetail {
    public static void main(String[] args) {
        // Base Order
        Order order = new Order(101, "2025-08-30");
        order.displayOrderDetails();
        System.out.println("Status: " + order.getOrderStatus());
        System.out.println();
        ShippedOrder shipped = new ShippedOrder(102, "2025-08-28", "TRK12345XYZ");
        shipped.displayOrderDetails();
        System.out.println("Status: " + shipped.getOrderStatus());
        System.out.println();
        DeliveredOrder delivered = new DeliveredOrder(103, "2025-08-25", "TRK98765ABC", "2025-08-29");
        delivered.displayOrderDetails();
        System.out.println("Status: " + delivered.getOrderStatus());
    }
}
