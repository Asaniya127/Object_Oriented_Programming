import java.util.ArrayList;

// Employee class: tightly bound to Department
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayInfo() {
        System.out.println("Employee: " + name + " | Role: " + role);
    }
}

// Department class: tightly bound to Company
class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showDepartmentDetails() {
        System.out.println("Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }

    public void clearEmployees() {
        employees.clear(); // Simulate deletion
    }
}

// Company class: owns Departments and Employees (composition)
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.showDepartmentDetails();
        }
    }

    public void dissolveCompany() {
        System.out.println("Dissolving company: " + companyName);
        for (Department dept : departments) {
            dept.clearEmployees(); // Remove employees
        }
        departments.clear(); // Remove departments
    }
}

// Main class to demonstrate composition
public class Q3Composition_company {
    public static void main(String[] args) {
        // Create company
        Company techCorp = new Company("TechCorp Pvt Ltd");

        // Create departments
        Department rnd = new Department("R&D");
        Department hr = new Department("Human Resources");

        // Add employees to departments
        rnd.addEmployee("Dhruv Jain", "AI Researcher");
        rnd.addEmployee("Neha Sharma", "Vision Engineer");
        hr.addEmployee("Amit Verma", "HR Manager");

        // Add departments to company
        techCorp.addDepartment(rnd);
        techCorp.addDepartment(hr);

        // Show company structure
        techCorp.showCompanyStructure();

        // Dissolve company (composition: all sub-objects removed)
        System.out.println("\n--- Company Shutdown ---");
        techCorp.dissolveCompany();

        // Try to show structure again (should be empty)
        techCorp.showCompanyStructure();
    }
}
