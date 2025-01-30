public class Circle{
   public static void main(String args[]){
      Circleee obj=new Circleee(2.5);
      obj.areaOfCircle();
      obj.circumferenceOfCircle();
   }
}

class Circleee{
     double radius;
     public Circleee(double radius){
        this.radius=radius;
     }
     public void areaOfCircle(){
         System.out.println("Area of circle is "+(3.14*radius*radius));
     }
     public void circumferenceOfCircle(){
         System.out.println("Circumference of circle is "+(2*3.14*radius));
     }   
} 

