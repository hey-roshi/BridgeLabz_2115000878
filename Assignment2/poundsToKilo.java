import java.util.*;
public class poundsToKilo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Taking user input for weight in pounds
        System.out.print("Enter the weight in pounds:");
        double weightInPounds=sc.nextDouble();
        // Conversion factor:1 pound = 2.2 kg
        double weightInKg=weightInPounds*2.2;
        // Displaying the result
        System.out.println("The weight of the person in pounds is "+weightInPounds+
                           " and in kilograms is "+weightInKg);
    }
}
