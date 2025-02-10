import java.util.*;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> medicalRecords = new ArrayList<>();

    public InPatient(int patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

// Hospital Management System
public class HospitalManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient(101, "John Doe", 45, 500, 5);
        inPatient.addRecord("Admitted for surgery");
        patients.add(inPatient);

        OutPatient outPatient = new OutPatient(102, "Jane Smith", 30, 200);
        outPatient.addRecord("Routine check-up");
        patients.add(outPatient);

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());
            if (patient instanceof MedicalRecord) {
                System.out.println("Medical Records: " + ((MedicalRecord) patient).viewRecords());
            }
            System.out.println("---------------------------");
        }
    }
}
