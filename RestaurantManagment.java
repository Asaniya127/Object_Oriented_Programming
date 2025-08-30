// Interface
interface Worker {
    void performDuties();
}

class Person1 {
    String name;
    int id;

    Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
class Chef extends Person1 implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing delicious " + specialty + " dishes.");
    }
}
class Waiter extends Person1 implements Worker {
    int tablesAssigned;

    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
}
public class RestaurantManagment{
    public static void main(String[] args) {
        Chef chef = new Chef("Arjun", 101, "Italian");
        chef.displayDetails();
        chef.performDuties();
        System.out.println();
        Waiter waiter = new Waiter("Rahul", 201, 5);
        waiter.displayDetails();
        waiter.performDuties();
    }
}
