// Program to Simulate Student Report

class Student {
    String name;
    int rollNumber;
    double marks;

    // Constructor to initialize student details
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade
    String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method to display details and grade
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args) {
        // Create Student objects
        Student student1 = new Student("Ananya Gupta", 101, 95);
        Student student2 = new Student("Rohan Mehta", 102, 72);
        Student student3 = new Student("Simran Kaur", 103, 58);

        // Display reports
        System.out.println("Student 1 Report:");
        student1.displayDetails();

        System.out.println("\nStudent 2 Report:");
        student2.displayDetails();

        System.out.println("\nStudent 3 Report:");
        student3.displayDetails();
    }
}
