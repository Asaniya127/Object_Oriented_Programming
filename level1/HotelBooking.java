package JavaConstructors.Level1;

import java.util.Scanner;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public HotelBooking() {
        this("Guest", "Standard", 1);
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter guest name: ");
        String name = sc.nextLine();
        System.out.print("Enter room type: ");
        String room = sc.nextLine();
        System.out.print("Enter number of nights: ");
        int nights = sc.nextInt();

        HotelBooking hb = new HotelBooking(name, room, nights);
        HotelBooking copy = new HotelBooking(hb);
        hb.display();
        copy.display();
    }
}
