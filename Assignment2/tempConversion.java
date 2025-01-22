import java.util.*;
public class tempConversion{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Taking input for Celsius temperature
        System.out.print("Enter the temperature in Celsius: ");
        double celsius=sc.nextDouble();

        // Converting Celsius to Fahrenheit using the formula
        double fahrenheitResult=(celsius*9/5)+32;

        // Displaying the result
        System.out.println("The " + celsius + " Celsius is " + fahrenheitResult + " Fahrenheit");
    }
}

