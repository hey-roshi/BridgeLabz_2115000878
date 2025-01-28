import java.util.*;
public class unitConvertor3{
   public static double FahrenheitToCelsius(double fahrenheit) {
      return (fahrenheit - 32) * 5 / 9;
   }
   public static double CelsiusToFahrenheit(double celsius) {
      return (celsius * 9 / 5) + 32;
   }
   public static double PoundsToKilograms(double pounds) {
      return pounds * 0.453592;
   }
   public static double KilogramsToPounds(double kilograms) {
      return kilograms * 2.20462;
   }
   public static double GallonsToLiters(double gallons) {
      return gallons * 3.78541;
   }
   public static double LitersToGallons(double liters) {
      return liters * 0.264172;
   }
   public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the degree in Fahrenheit:");
        double fah=sc.nextDouble();
        System.out.println("Enter degree in celsius:");
        double cel=sc.nextDouble();
        System.out.println("Enter degree in pound:");
        double pound=sc.nextDouble();
        System.out.println("Enter degree in kilo:");
        double kilo=sc.nextDouble();
        System.out.println("Enter degree in gallon:");
        double gallon=sc.nextDouble();
        System.out.println("Enter degree in litres:");
        double litre=sc.nextDouble();

        System.out.println("Degree in fahrenheit to celsius is: "+FahrenheitToCelsius(fah));
        System.out.println("Degree in celsius to fahrenheit is: "+CelsiusToFahrenheit(cel));
        System.out.println("Degree in pounds to kilo is: "+PoundsToKilograms(pound));
        System.out.println("Degree in kilo to pounds is: "+KilogramsToPounds(kilo));
        System.out.println("Degree in gallons to litres is: "+GallonsToLiters(gallon));
        System.out.println("Degree in litres to gallons is: "+LitersToGallons(litre));
   }
}
