import java.util.*;
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public String getType() {
        return type;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }
    public abstract double calculateRentalCost(int days);
    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: ₹" + rentalRate + " per day");
    }
}
class Car extends Vehicle {
    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy No: " + getInsurancePolicyNumber();
    }
}
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9;
    }
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; 
    }
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy No: " + getInsurancePolicyNumber();
    }
}
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }
    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; 
    }
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy No: " + getInsurancePolicyNumber();
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C101", 2000, "CAR-INS-789"));
        vehicles.add(new Bike("B202", 800, "BIKE-INS-456"));
        vehicles.add(new Truck("T303", 3500, "TRUCK-INS-123"));
        int rentalDays = 5;
        System.out.println("=== Vehicle Rental System ===\n");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = v.calculateInsurance();

            System.out.println("Rental Duration: " + rentalDays + " days");
            System.out.println("Total Rental Cost: ₹" + rentalCost);
            System.out.println("Insurance Cost: ₹" + insuranceCost);
            System.out.println(v.getInsuranceDetails());
            System.out.println("----------------------------------");
        }
    }
}