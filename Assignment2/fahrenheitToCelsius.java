import java.util.Scanner;

public class fahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Taking input for Fahrenheit temperature
        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit=sc.nextDouble();

        // Converting Fahrenheit to Celsius using the formula
        double celsius=(fahrenheit - 32) * 5 / 9;

        // Displaying the result
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius");

      
    }
}
