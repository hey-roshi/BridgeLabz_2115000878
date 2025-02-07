public class Employee{
   String name; 
   int id;
   int salary;
   public Employee(String name, int id, int salary){
      this.name=name;
      this.id=id;
      this.salary=salary;
   }
   public void displayDetails(){ 
        System.out.println("Name of employee is: "+name);
        System.out.println("Id of employee is: "+id);
        System.out.println("Salary of employee is: "+salary);
   }
   public static void main(String args[]){
      Employee obj1=new Employee("rosh",01,50);
      obj1.displayDetails();
      Employee obj2=new Manager("aashi",02,60,10);
      obj2.displayDetails();
      Employee obj3=new Developer("rashi",03,70,12,"python");
      obj3.displayDetails();
   }
}
class Manager extends Employee{
    int teamSize;
    public Manager(String name, int id, int salary, int teamSize){
        super(name, id, salary);
        this.teamSize=teamSize;
    }
    public void displayDetails(){
        System.out.println("Name of employee is: "+name);
        System.out.println("Id of employee is: "+id);
        System.out.println("Salary of employee is: "+salary);
        System.out.println("Team size is: "+teamSize);
    }
}
class Developer extends Employee{
    String progLang;
    public Developer(String name, int id, int salary, int teamSize,String progLang){
        super(name, id, salary);
        this.progLang=progLang;
    }
    public void displayDetails(){
        System.out.println("Name of employee is: "+name);
        System.out.println("Id of employee is: "+id);
        System.out.println("Salary of employee is: "+salary);
        System.out.println("Programming language is: "+progLang);
    }
}
class Intern extends Employee{
    int experience;
    public Intern(String name, int id, int salary, int teamSize,int experience){
        super(name, id, salary);
        this.experience=experience;
    }
    public void displayDetails(){
        System.out.println("Name of employee is: "+name);
        System.out.println("Id of employee is: "+id);
        System.out.println("Salary of employee is: "+salary);
        System.out.println("Experience is: "+experience);
    }
}




