public class Employee{
   public static void main(String args[]){
     Emp emp1=new Emp("Roshi", 90, 45.0);
     emp1.displayDetails();
   }
}
class Emp{
   String name;
   int id;
   double salary;
   public Emp(String name, int id, double salary){
       this.name=name;
       this.id=id;
       this.salary=salary;
  }  
  public void displayDetails(){
        System.out.println("The employee name is "+name);
        System.out.println("The employee id is "+id);
        System.out.println("The employee salary is "+salary);
  }
}

  
