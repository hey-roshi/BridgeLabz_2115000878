import java.util.Scanner;
public class heightInFeetAndInches{
     public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
           double heightInCm, heightInInches, heightInFeet, remainingInches;
           System.out.print("Enter your height in centimeters: ");
           heightInCm = sc.nextDouble();
           heightInInches = heightInCm / 2.54;
           heightInFeet = Math.floor(heightInInches / 12);
           remainingInches = heightInInches % 12;
           System.out.println("Your height in cm is "+heightInCm+" while in feet is "+heightInFeet+" and inches is "+remainingInches);
     }
}
