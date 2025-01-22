import java.util.Scanner;
    public class kiloToMiles{
       public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           System.out.print("Enter the distance in kilometers: ");
           double kilometer = sc.nextDouble();
           double miles = kilometer / 1.6; //Conversion
           System.out.printf("The total miles is "+miles);
      }
    }
