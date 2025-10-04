import java.util.ArrayList;

// Course class: associated with students and professors
class Course {
    private String courseName;
    private Professor professor;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor prof) {
        this.professor = prof;
        prof.addCourse(this); // Bidirectional association
        System.out.println("Professor " + prof.getName() + " assigned to course " + courseName);
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            student.addCourse(this); // Bidirectional association
            System.out.println("Student " + student.getName() + " enrolled in course " + courseName);
        }
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not assigned"));
        System.out.println("Enrolled Students:");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }
}

// Student class: associated with multiple courses
class Student {
    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " | Enrolled Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// Professor class: teaches multiple courses
class Professor {
    private String name;
    private ArrayList<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCoursesTaught() {
        System.out.println("Professor: " + name + " | Courses Taught:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// University class: aggregates students, professors, and courses
class University {
    private String universityName;
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;
    private ArrayList<Course> courses;

    public University(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showUniversityStructure() {
        System.out.println("University: " + universityName);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println("- " + p.getName());
        }
        System.out.println("Courses:");
        for (Course c : courses) {
            c.showCourseDetails();
            System.out.println();
        }
    }
}

// Main class to demonstrate the system
public class Q5UniversitySystem{
    public static void main(String[] args) {
        // Create university
        University chitkara = new University("Chitkara University");

        // Create students
        Student dhruv = new Student("Dhruv Jain");
        Student rhea = new Student("Rhea Kapoor");

        // Create professors
        Professor profMehta = new Professor("Prof. Mehta");
        Professor profRao = new Professor("Dr. Rao");

        // Create courses
        Course ai = new Course("Artificial Intelligence");
        Course cv = new Course("Computer Vision");

        // Add entities to university
        chitkara.addStudent(dhruv);
        chitkara.addStudent(rhea);
        chitkara.addProfessor(profMehta);
        chitkara.addProfessor(profRao);
        chitkara.addCourse(ai);
        chitkara.addCourse(cv);

        // Assign professors and enroll students
        ai.assignProfessor(profMehta);
        cv.assignProfessor(profRao);

        ai.enrollStudent(dhruv);
        cv.enrollStudent(dhruv);
        ai.enrollStudent(rhea);

        // Show full university structure
        System.out.println("\n--- University Overview ---");
        chitkara.showUniversityStructure();

        // Individual views
        System.out.println("\n--- Individual Views ---");
        dhruv.viewCourses();
        rhea.viewCourses();
        profMehta.viewCoursesTaught();
        profRao.viewCoursesTaught();
    }
}
