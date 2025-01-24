import java.util.*;
public class numberAnalysis{ 
    public static void main(String[] args){
        // Array to store 5 numbers
        int[] numbers=new int[5];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 5 numbers:");
        for(int i=0;i<numbers.length;i++){
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i]=sc.nextInt();
        }
        // Analysis of each number
        for(int i = 0; i<numbers.length; i++) {
            if(numbers[i]>0){
                if (numbers[i] % 2 == 0) {
                    System.out.println("The number " + numbers[i] + " is positive and even.");
                }else {
                    System.out.println("The number " + numbers[i] + " is positive and odd.");
                }
            }else if (numbers[i] < 0) {
                System.out.println("The number " + numbers[i] + " is negative.");
            }else {
                System.out.println("The number " + numbers[i] + " is zero.");
            }
        }

        // Compare the first and last elements of the array
        if (numbers[0] > numbers[4]) {
            System.out.println("The first number (" + numbers[0] + ") is greater than the last number (" + numbers[4] + ").");
        }else if (numbers[0] < numbers[4]) {
            System.out.println("The first number (" + numbers[0] + ") is less than the last number (" + numbers[4] + ").");
        }else {
            System.out.println("The first number (" + numbers[0] + ") is equal to the last number (" + numbers[4] + ").");
        }
    }

}
