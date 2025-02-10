import java.util.*;
public class EmployeeMagt{
    public static void main(String[] args){
        List<Employee> employees=new ArrayList<>();
        FullTimeEmployee fte=new FullTimeEmployee(1, "Alice", 50000);
        fte.assignDepartment("HR");
        employees.add(fte);
        PartTimeEmployee pte=new PartTimeEmployee(2, "Bob", 20, 100);
        pte.assignDepartment("IT");
        employees.add(pte);
        for(Employee emp:employees){
            emp.displayDetails();
            //if(emp instanceof Department){
               System.out.println(((Department)emp).getDepartment());
           //}
            System.out.println("----------------------");
        }
    }
}
abstract class Employee{
    private static int empId;
    private static String empName;
    private static double baseSalary;
    public Employee(int empId, String empName, double baseSalary){
          this.empId=empId;
          this.empName=empName;
          this.baseSalary=baseSalary;
    }
    public int getEmpId(){
       return empId;
    }
    public String getName(){
       return empName;
    }
    public double getBase(){
       return baseSalary;
    }
    public void setBase(double baseSalary){
       this.baseSalary=baseSalary; 
    }
    abstract double calculateSalary();
    public static void displayDetails(){
       System.out.println("The employee id is "+empId);
       System.out.println("The employee name is "+empName);
       System.out.println("The base salary is "+baseSalary);
    }

}
interface Department{
     void assignDepartment(String departmentName);
     String getDepartment();
}
class FullTimeEmployee extends Employee implements Department{
     private String department;
     public FullTimeEmployee(int empId,String empName,double baseSalary){
        super(empId,empName,baseSalary);
     }
     public double calculateSalary(){
        return getBase();
     }
     public void assignDepartment(String departmentName){
        this.department=departmentName;
     }
     public String getDepartment(){
        return "Department: "+department;
     }
}
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;
    public PartTimeEmployee(int employeeId, String name, double hourlyRate, int hoursWorked) {
        super(employeeId, name, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    public double calculateSalary() {
        return hourlyRate * hoursWorked; // Salary based on hours worked
    }
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }
    public String getDepartment() {
        return "Department: " + department;
    }
}

