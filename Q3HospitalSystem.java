import java.util.ArrayList;

// Patient class: can consult multiple doctors
class Patient {
    private String name;
    private ArrayList<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    public void viewConsultedDoctors() {
        System.out.println("Patient: " + name + " | Consulted Doctors:");
        for (Doctor doc : consultedDoctors) {
            System.out.println("- Dr. " + doc.getName());
        }
    }
}

// Doctor class: can consult multiple patients
class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this); // Bidirectional association
        }
        System.out.println("Consultation: Dr. " + name + " (" + specialization + ") is seeing patient " + patient.getName());
    }

    public void viewPatients() {
        System.out.println("Dr. " + name + " | Patients:");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

// Hospital class: aggregates doctors and patients
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalRoster() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("- Dr. " + doc.getName() + " (" + doc.specialization + ")");
        }
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println("- " + pat.getName());
        }
    }
}

// Main class to demonstrate association and communication
public class Q3HospitalSystem {
    public static void main(String[] args) {
        // Create hospital
        Hospital medCare = new Hospital("MedCare Hospital");

        // Create doctors
        Doctor dhruv = new Doctor("Dhruv Jain", "Neurology");
        Doctor rhea = new Doctor("Rhea Kapoor", "Cardiology");

        // Create patients
        Patient amit = new Patient("Amit Verma");
        Patient neha = new Patient("Neha Sharma");

        // Add to hospital
        medCare.addDoctor(dhruv);
        medCare.addDoctor(rhea);
        medCare.addPatient(amit);
        medCare.addPatient(neha);

        // Consultations (association + communication)
        dhruv.consult(amit);
        dhruv.consult(neha);
        rhea.consult(amit);

        // View relationships
        System.out.println();
        dhruv.viewPatients();
        rhea.viewPatients();
        System.out.println();
        amit.viewConsultedDoctors();
        neha.viewConsultedDoctors();
    }
}
