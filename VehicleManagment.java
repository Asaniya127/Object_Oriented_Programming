// Interface
interface Refuelable {
    void refuel();
}
class Vehicle1 {
    String model;
    int maxSpeed;

    Vehicle1(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
class ElectricVehicle extends Vehicle1 {
    int batteryCapacity;

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging with battery capacity of " + batteryCapacity + " kWh.");
    }
}
class PetrolVehicle extends Vehicle1 implements Refuelable {
    int fuelCapacity;

    PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with capacity of " + fuelCapacity + " liters.");
    }
}
public class VehicleManagment {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 75);
        ev.displayInfo();
        ev.charge();

        System.out.println();

        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);
        pv.displayInfo();
        pv.refuel();
    }
}
