import java.util.ArrayList;

// Course class: associated with multiple students
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Bidirectional association
        }
    }

    public void showEnrolledStudents() {
        System.out.println("Course: " + courseName + " | Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

// Student class: aggregated by School, associated with multiple courses
class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " | Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// School class: aggregates students
class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student); // Aggregation: student can exist outside school
    }

    public void showStudents() {
        System.out.println("School: " + schoolName + " | Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// Main class to demonstrate aggregation and association
public class Q1SchoolSystemDemo {
    public static void main(String[] args) {
        // Create school
        School chitkara = new School("Chitkara University");

        // Create students
        Student dhruv = new Student("Dhruv Jain");
        Student rhea = new Student("Rhea Kapoor");

        // Add students to school (aggregation)
        chitkara.addStudent(dhruv);
        chitkara.addStudent(rhea);

        // Create courses
        Course ai = new Course("Artificial Intelligence");
        Course cv = new Course("Computer Vision");
        Course ds = new Course("Data Structures");

        // Enroll students in courses (association)
        ai.enrollStudent(dhruv);
        cv.enrollStudent(dhruv);
        ds.enrollStudent(rhea);
        ai.enrollStudent(rhea);

        // Display school students
        chitkara.showStudents();
        System.out.println();

        // Display student courses
        dhruv.viewCourses();
        rhea.viewCourses();
        System.out.println();

        // Display course enrollments
        ai.showEnrolledStudents();
        cv.showEnrolledStudents();
        ds.showEnrolledStudents();
    }
}
