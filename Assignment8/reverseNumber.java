import java.util.Scanner;
public class reverseNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // Input the number
        System.out.print("Enter a positive number: ");
        int number=sc.nextInt();
        if(number<=0){
            System.out.println("Please enter a positive number.");
            return;
        }
        // Find the count of digits
        int tempNumber=number;
        int digitCount=0;
        while(tempNumber!=0){
            tempNumber/=10; // Remove the last digit
            digitCount++;
        }
        // Create an array to store the digits
        int[] digits=new int[digitCount];
        // Extract digits and store them in the array
        for(int i=0;i<digitCount;i++){
            digits[i]=number%10; // Get the last digit
            number/=10; // Remove the last digit
        }
        // Display the digits in reverse order
        System.out.println("Digits of the number in reverse order:");
        for(int i=0;i<digitCount;i++){
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
