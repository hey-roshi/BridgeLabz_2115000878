import java.util.Scanner;
class Employee{
    static String companyName="Tech Solutions";
    static int totalEmployees=0;
    final int id;
    String name;
    String designation;

    public Employee(String name, int id, String designation){
        this.name=name;
        this.id=id;
        this.designation=designation;
        totalEmployees++;
    }
    static void displayTotalEmployees(){
        System.out.println("Total Employees: " + totalEmployees);
    }
    void displayDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
    }
}

public class EmployeeManagement{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter designation: ");
        String designation = scanner.nextLine();
        
        Employee employee = new Employee(name, id, designation);
        if(employee instanceof Employee){
           Employee.displayTotalEmployees();
           employee.displayDetails();
        }else{
           System.out.println("Not instance");
        }
    }
}
