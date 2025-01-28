import java.util.*;
public class unitConverter2{
   public static double YardstoFeet(double yards){
     double yards2feet = 3;
     return yards*yards2feet;
   }
   public static double FeettoYards(double feet){
     double feet2yards=0.333333;
     return feet*feet2yards;
   }
   public static double MeterstoInches(double meters){
     double meters2inches = 39.3701;
     return meters * meters2inches;
   }
   public static double InchestoMeters(double inches){
     double inches2meters = 0.0254;
     return inches*inches2meters;
   }
   public static double InchestoCm(double inches){
     double inches2cm = 2.54;
     return inches*inches2cm;
   }
   public static void main(String[]args){
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter distance in yards:");
     double yards=sc.nextDouble();;
     System.out.println("Enter distance in feet:");
     double feet=sc.nextDouble();
     System.out.println("Enter distance in meters:");
     double meters=sc.nextDouble();
     System.out.println("Enter distance in inches:");
     double inches=sc.nextDouble();
     System.out.println("Enter distance in inchescm:");
     double inchescm=sc.nextDouble();
     System.out.println(yards+ " yards is "+ YardstoFeet(yards)+ " feet.");
     System.out.println(feet + " feet is " + FeettoYards(feet) + " yards.");
     System.out.println(meters + " meters is " + MeterstoInches(meters) + " inches.");
     System.out.println(inches + " inches is " +InchestoMeters(inches) + " meters.");
     System.out.println(inchescm + " inches is " + InchestoCm(inches) + " cm.");
   }
}
