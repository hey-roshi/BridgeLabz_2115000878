import java.util.*;
public class sumOfNumbers{
    public static void main(String[] args){
        double[] numbers=new double[10];
        double total=0.0;
        int index=0;
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Enter a number (0 or -ve to stop): ");
            double userInput=sc.nextDouble();
            // Terminate the loop if the user enters 0 or a -ve number
            if(userInput<=0){
                break;
            }
            // Break the loop if an array is full
            if(index==10){
                System.out.println("Maximum limit of numbers reached.");
                break;
            }
            numbers[index]=userInput;
            index++;
        }
        // Calculate the total sum of the user entered numbers
        for(int i=0;i<index;i++){
            total+=numbers[i];
        }
        System.out.println("You entered the following numbers:");
        for(int i=0;i<index;i++){
            System.out.println(numbers[i]);
        }
        System.out.println("The total sum of the numbers is: " + total);
    }
}
