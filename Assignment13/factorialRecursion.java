import java.util.*;
public class factorialRecursion{
    public static void main(String[] args){
        int num=takeInput("Enter a number: ");
        long fact=calculateFactorial(num);
        displayResult(num,fact);
    }
    private static int takeInput(String prompt){
        Scanner sc=new Scanner(System.in);
        System.out.print(prompt);
        int input = sc.nextInt();
        return input >= 0 ? input : takeInput("Please enter a non-negative integer: ");
    }
    private static long calculateFactorial(int num){
        if(num==0||num==1){
            return 1;
        }
        return num*calculateFactorial(num-1);
    }
    private static void displayResult(int num, long fact) {
        System.out.println("The factorial of " + num + " is: " + fact);
    }
}

