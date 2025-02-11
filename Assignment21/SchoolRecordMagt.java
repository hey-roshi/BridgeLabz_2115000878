import java.util.*;
class Student{
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;
    public Student(int rollNo,String name,int age,char grade){
         this.rollNo=rollNo;
         this.name=name;
         this.age=age;
         this.grade=grade;
         this.next=null;
    }
}
class StudentList{
    private Student head;
    public void addStudent(int rollNo,String name,int age,char grade){
        Student newStudent=new Student(rollNo,name,age,grade);
        if(head==null){
            head=newStudent;
            return;
        }
        Student temp=head;
        while(temp.next!=null){
             temp=temp.next;
        }
        temp.next=newStudent;
     }
     public void deleteStudent(int rollNo){
        if(head==null){
             System.out.println("list is empty");
         } 
         if(head.rollNo==rollNo){
              head=head.next;
              return; 
         }
         Student temp=head;
         while(temp.next!=null && temp.next.rollNo!=rollNo){
              temp=temp.next;
         }
         if(temp.next==null){
              System.out.println("not found");
         }else{
              temp.next=temp.next.next;
         }
      }
      public Student searchStudent(int rollNo){
         Student temp=head;
         while(temp!=null){
            if(temp.rollNo==rollNo){
                return temp;
             }
             temp=temp.next;
         }
         return null;
      }
       public void displayStudents() {
        if (head == null) {
            System.out.println("No students found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Student not found.");
        }
    }
}
public class SchoolRecordMagt{
  public static void main(String args[]){
      Scanner scanner = new Scanner(System.in);
        StudentList ans= new StudentList();

        ans.addStudent(1, "Alice", 20,'A');
        ans.addStudent(2, "Bob", 22,'B');
        ans.addStudent(3, "Charlie", 21, 'C');

        System.out.println("Initial Student Records:");
        ans.displayStudents();

        System.out.println("\nUpdating Grade for Roll Number 2...");
        ans.updateGrade(2, 'D');
        ans.displayStudents();

        System.out.println("\nDeleting Student with Roll Number 1...");
        ans.deleteStudent(1);
        ans.displayStudents();
  }
}
