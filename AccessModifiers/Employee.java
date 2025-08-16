package JavaConstructors.AccessModifiers;

import java.util.Scanner;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public double getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void display() {
        System.out.println("Manager ID: " + employeeID + ", Department: " + department);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double sal = sc.nextDouble();

        Manager m = new Manager(id, dept, sal);
        m.display();
        System.out.println("Current Salary: ₹" + m.getSalary());
        System.out.print("Enter new salary: ");
        double newSal = sc.nextDouble();
        m.updateSalary(newSal);
        System.out.println("Updated Salary: ₹" + m.getSalary());
    }
}


