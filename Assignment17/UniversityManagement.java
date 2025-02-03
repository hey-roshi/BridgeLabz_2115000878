import java.util.Scanner;
class Student{
    static String universityName="Global University";
    static int totalStudents=0;
    final int rollNumber;
    String name;
    String grade;
    public Student(String name, int rollNumber, String grade){
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
        totalStudents++;
    }
    static void displayTotalStudents(){
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    void displayDetails(){
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
    }
}
public class UniversityManagement{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        
        Student student = new Student(name, rollNumber, grade);
        if(student instanceof Student){
           Student.displayTotalStudents();
           student.displayDetails();
        }else{
           System.out.println("Not instance");
        }
    }
}
