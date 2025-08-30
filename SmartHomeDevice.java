class Device{
    int DeviceId;
    String status;

    Device(int DeviceId, String status){
        this.DeviceId = DeviceId;
        this.status = status;
    }
    void displayStatus() {
        System.out.println("Device ID: " + DeviceId);
        System.out.println("Status: " + status);
    }
}
class Thermostat extends Device{
    int temperatureSetting;

    Thermostat(int DeviceId, String status, int temperatureSetting){
        super(DeviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    void displayStatus(){
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°F");

    }
}
public class SmartHomeDevice {
    public static void main(String[] args){
        Thermostat T1 = new Thermostat(1234, "ON", 24);
        T1.displayStatus();
    }
}

