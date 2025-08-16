package JavaConstructors.Instance;

import java.util.Scanner;

class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static double registrationFee = 1500.0;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName + ", Type: " + vehicleType + ", Fee: ₹" + registrationFee);
    }

    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new registration fee: ");
        double fee = sc.nextDouble();
        updateRegistrationFee(fee);
        sc.nextLine(); // consume newline

        System.out.print("Enter owner name: ");
        String name = sc.nextLine();
        System.out.print("Enter vehicle type: ");
        String type = sc.nextLine();

        Vehicle v = new Vehicle(name, type);
        v.displayVehicleDetails();
    }
}
