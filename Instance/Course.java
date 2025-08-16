package JavaConstructors.Instance;

import java.util.Scanner;

class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "Default Institute";

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " weeks, Fee: ₹" + fee + ", Institute: " + instituteName);
    }

    public static void updateInstituteName(String name) {
        instituteName = name;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter institute name: ");
        String inst = sc.nextLine();
        updateInstituteName(inst);

        System.out.print("Enter course name: ");
        String cname = sc.nextLine();
        System.out.print("Enter duration (weeks): ");
        int dur = sc.nextInt();
        System.out.print("Enter fee: ");
        double fee = sc.nextDouble();

        Course c = new Course(cname, dur, fee);
        c.displayCourseDetails();
    }
}
