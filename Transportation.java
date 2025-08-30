class Vehicle{
    int maxSpeed;
    String fueltype;
    Vehicle(int maxSpeed,String fueltype){
        this.maxSpeed = maxSpeed;
        this.fueltype = fueltype;
    }
    void displayInfo(){
        System.out.println("MaxSpeed " + maxSpeed + ", fueltype " + fueltype);
    }

}
class Car extends Vehicle {
    int seatcapacity;

    Car(int maxSpeed, String fueltype, int seatcapacity){
        super(maxSpeed,fueltype);
        this.seatcapacity = seatcapacity;
    }
    void displayInfo(){
        super.displayInfo();
        System.out.println("Type: Car, Seat Capacity: " + seatcapacity);
    }

}
class Truck extends  Vehicle{
    int loadCapacity;

    Truck(int maxSpeed, String fueltype, int loadCapacity){
        super(maxSpeed, fueltype);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck , loadCapacity: " + loadCapacity);
    }
}
class MotorCycle extends  Vehicle{;
    boolean hassidecar;
    MotorCycle(int maxSpeed, String fueltype, boolean hassidecar){
        super(maxSpeed, fueltype);
        this.hassidecar = hassidecar;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle, Sidecar: " + (hassidecar ? "Yes" : "No"));
    }
}
public class Transportation {
    public static void main(String[] args){
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car(180, "Petrol", 5);
        vehicles[1] = new Truck(120, "Diesel", 10);
        vehicles[2] = new MotorCycle(150, "Petrol", false);

        // Demonstrating polymorphism
        for (Vehicle v : vehicles) {
            v.displayInfo();
            System.out.println("----------------");
        }
    }
}
