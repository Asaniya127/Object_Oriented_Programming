
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicle implements GPS {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }


    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
        System.out.println("Location updated to: " + currentLocation);
    }
}
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8;
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) + 10;
    }
}


public class RideHailingApplication {

    public static void printFare(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + fare);
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C101", "Rohit Sharma", 15.0, "Connaught Place");
        Vehicle bike = new Bike("B202", "Aman Verma", 10.0, "Karol Bagh");
        Vehicle auto = new Auto("A303", "Suresh Kumar", 12.0, "Rajouri Garden");

        System.out.println("=== Ride Hailing Fare Calculation ===\n");

        printFare(car, 10.5);
        printFare(bike, 10.5);
        printFare(auto, 10.5);
        car.updateLocation("India Gate");
        System.out.println("Car Current Location: " + car.getCurrentLocation());
    }
}

