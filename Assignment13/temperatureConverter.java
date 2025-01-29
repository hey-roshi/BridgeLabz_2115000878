import java.util.*;
public class temperatureConverter{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Convert Fahrenheit to Celsius");
        System.out.println("2. Convert Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                double fahrenheit = getInput("Enter temperature in Fahrenheit: ");
                double celsius = convertFahrenheitToCelsius(fahrenheit);
                System.out.println(fahrenheit + " Fahrenheit is equal to " + celsius + " Celsius.");
                break;
            case 2:
                celsius = getInput("Enter temperature in Celsius: ");
                fahrenheit = convertCelsiusToFahrenheit(celsius);
                System.out.println(celsius + " Celsius is equal to " + fahrenheit + " Fahrenheit.");
                break;
            default:
                System.out.println("Invalid choice. Please select either 1 or 2.");
        }
    }

    private static double getInput(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextDouble();
    }
    private static double convertFahrenheitToCelsius(double fahrenheit){
        return(fahrenheit-32)*5/9;
    }
    private static double convertCelsiusToFahrenheit(double celsius){
        return(celsius*9/5)+32;
    }
}
