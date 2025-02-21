import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Employee class must implement Serializable
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures compatibility during deserialization
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Display employee details
    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }
}

public class employeeSerialization{
    private static final String FILE_NAME = "employees.ser";

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "HR", 55000));
        employeeList.add(new Employee(102, "Bob", "IT", 70000));
        employeeList.add(new Employee(103, "Charlie", "Finance", 65000));

        // Serialize the list of employees
        serializeEmployees(employeeList);

        // Deserialize and retrieve employees from the file
        List<Employee> retrievedEmployees = deserializeEmployees();
        if (retrievedEmployees != null) {
            System.out.println("\nRetrieved Employee List:");
            for (Employee emp : retrievedEmployees) {
                emp.display();
            }
        }
    }

    // Method to serialize (save) employees to a file
    private static void serializeEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
        }
    }

    // Method to deserialize (load) employees from a file
    @SuppressWarnings("unchecked") // Suppresses warning for type casting
    private static List<Employee> deserializeEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Employee>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Error deserializing employees: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
        return null;
    }
}
