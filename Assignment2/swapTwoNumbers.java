import java.util.*;
public class swapTwoNumbers{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Taking input for the two numbers
        System.out.print("Enter the first number: ");
        int number1=sc.nextInt();

        System.out.print("Enter the second number: ");
        int number2=sc.nextInt();

        // Swapping logic
        int temp=number1;
        number1=number2;
        number2=temp;

        // Displaying numbers after swapping
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

       
    }
}

