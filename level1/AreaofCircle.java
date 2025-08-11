// Circle.java
import java.util.Scanner;

class Circle {
    // Attribute
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("---- Circle Details ----");
        System.out.println("Radius        : " + radius);
        System.out.println("Area          : " + calculateArea());
        System.out.println("Circumference : " + calculateCircumference());
    }
}

public class AreaofCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking radius input from user
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();

        // Creating Circle object
        Circle c = new Circle(radius);

        // Displaying area and circumference
        c.displayDetails();

        sc.close();
    }
}
