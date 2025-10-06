interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = "";
        this.medicalHistory = "";
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    protected void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    protected void setMedicalHistory(String history) { this.medicalHistory = history; }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Total Bill: " + calculateBill());
        System.out.println("-----------------------------");
    }

    public void addRecord(String record) {
        this.medicalHistory += record + "; ";
    }

    public void viewRecords() {
        System.out.println("Medical Records for " + name + ": " + medicalHistory);
    }

    public abstract double calculateBill();
}

class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(String id, String name, int age, int days, double roomCharge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.roomChargePerDay = roomCharge;
    }

    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 2000;
    }
}

class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(String id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee;
    }
}

public class HospitelPatientManagement {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P101", "Alice", 30, 5, 1500);
        Patient p2 = new OutPatient("P202", "Bob", 45, 800);

        p1.addRecord("Diagnosed with fever");
        p2.addRecord("Routine check-up");

        p1.viewRecords();
        p2.viewRecords();

        Patient[] patients = {p1, p2};
        for (Patient p : patients) {
            p.getPatientDetails();
        }
    }
}
