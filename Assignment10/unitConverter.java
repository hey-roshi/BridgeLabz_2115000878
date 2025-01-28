import java.util.*;
public class unitConverter{
   public static double KmToMiles(double km) {
      double km2miles = 0.621371;
      return km * km2miles;
   }
   public static double MilesToKm(double miles) {
      double miles2km = 1.60934;
      return miles * miles2km;
   }
   public static double MetersToFeet(double meters) {
      double meters2feet = 3.28084;
      return meters * meters2feet;
   }
   public static double FeetToMeters(double feet) {
      double feet2meters = 0.3048;
      return feet * feet2meters;
   }
   public static void main(String[]args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter distance in kilometer:");
      double km=sc.nextDouble();
      System.out.println("Enter distance in miles:");
      double miles=sc.nextDouble();
      System.out.println("Enter distance in meters:");
      double meters=sc.nextDouble();
      System.out.println("Enter distance in feet:");
      double feet=sc.nextDouble();
      System.out.println(km + " km is " + KmToMiles(km) + " miles.");
      System.out.println(miles + " miles is " + MilesToKm(miles) + " km.");
      System.out.println(meters + " meters is " + MetersToFeet(meters) + " feet.");
      System.out.println(feet + " feet is " + FeetToMeters(feet) + " meters.");
   }
}
