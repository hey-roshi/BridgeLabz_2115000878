import java.util.Scanner;
public class largestDigits{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // Input the number
        System.out.print("Enter a positive number: ");
        int number=sc.nextInt();
        if(number<=0){
            System.out.println("Please enter a positive number.");
            return;
        }
        // Variables and Array Initialization
        int maxDigit=10;
        int[] digits=new int[maxDigit];
        int index=0;
        // Extract digits from the number and store in the array
        while(number!=0&&index<maxDigit){
            digits[index]=number%10; // Get the last digit
            number/=10; // Remove the last digit
            index++;
        }
        // Variables to store the largest and second largest digits
        int largest=0;
        int secondLargest=0;
        // Loop through the digits array
        for(int i=0;i<index;i++){
            if(digits[i]>largest){
                secondLargest=largest; // Update second largest
                largest=digits[i]; // Update largest
            }else if(digits[i]>secondLargest&&digits[i]!=largest){
                secondLargest=digits[i]; // Update second largest if it's not equal to the largest
            }
        }

        // Display results
        System.out.println("Results:");
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
