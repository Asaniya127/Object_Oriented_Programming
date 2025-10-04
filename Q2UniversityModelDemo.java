import java.util.ArrayList;

// Faculty class: Aggregated by University, can exist independently
class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayInfo() {
        System.out.println("Faculty: " + name + " | Specialization: " + specialization);
    }
}

// Department class: Composed within University
class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayInfo() {
        System.out.println("Department: " + deptName);
    }
}

// University class: Owns Departments (composition), aggregates Faculty
class University {
    private String universityName;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> facultyMembers;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty); // Aggregation: faculty can exist outside
    }

    public void showUniversityStructure() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayInfo();
        }
        System.out.println("Faculty Members:");
        for (Faculty fac : facultyMembers) {
            fac.displayInfo();
        }
    }

    public void dissolveUniversity() {
        System.out.println("Dissolving University: " + universityName);
        departments.clear(); // Composition: departments removed
        facultyMembers.clear(); // Aggregation: optional removal
    }
}

// Main class to demonstrate composition and aggregation
public class Q2UniversityModelDemo {
    public static void main(String[] args) {
        // Create independent faculty members
        Faculty dhruv = new Faculty("Dhruv Jain", "Computer Vision");
        Faculty rhea = new Faculty("Rhea Kapoor", "AI Ethics");

        // Create university
        University chitkara = new University("Chitkara University");

        // Add departments (composition)
        chitkara.addDepartment("Computer Science");
        chitkara.addDepartment("Electronics");

        // Add faculty (aggregation)
        chitkara.addFaculty(dhruv);
        chitkara.addFaculty(rhea);

        // Show structure
        chitkara.showUniversityStructure();

        // Dissolve university
        System.out.println("\n--- University Shutdown ---");
        chitkara.dissolveUniversity();

        // Show structure again (departments removed, faculty can still exist)
        chitkara.showUniversityStructure();

        // Faculty still exists independently
        System.out.println("\n--- Independent Faculty ---");
        dhruv.displayInfo();
        rhea.displayInfo();
    }
}
