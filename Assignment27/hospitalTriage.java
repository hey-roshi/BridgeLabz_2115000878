import java.util.*;

class Patient {
    String name;
    int severity; // Higher value means higher severity

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}

// Comparator to sort patients by severity (higher first)
class SeverityComparator implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity); // Descending order
    }
}

public class hospitalTriage{
    public static void main(String[] args) {
        // Priority Queue with custom comparator
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new SeverityComparator());

        // Adding patients
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        // Treat patients in order of severity
        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            Patient p = triageQueue.poll(); // Get the highest priority patient
            System.out.println(p.name + " (Severity: " + p.severity + ")");
        }
    }
}
