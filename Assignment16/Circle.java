import java.util.*;
public class Circle{
     double radius;
     public Circle(){
         this(8.0);
     }
     public Circle(double radius){
         this.radius=radius;
     }
     public double getArea(){
         return 3.14*radius*radius;
     }
     public double getCircumference(){
         return 2*3.14*radius;
     }
     public void displayDetails(){
        System.out.println("Area of circle is "+getArea());
        System.out.println("Circumference of circle is "+getCircumference());
     }
     public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the radius of circle:");
       double radius=sc.nextDouble();
       Circle obj1=new Circle(radius);
       obj1.displayDetails();
       Circle obj2=new Circle();
       obj2.displayDetails();
     }
}
     
