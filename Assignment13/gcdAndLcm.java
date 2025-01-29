import java.util.*;
public class gcdAndLcm{
    public static void main(String[] args) {
        int num1 = getInput("Enter the first number: ");
        int num2 = getInput("Enter the second number: ");
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        displayResults(num1, num2, gcd, lcm);
    }
    private static int getInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }
    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
    private static int calculateLCM(int a, int b, int gcd) {
        return(a*b)/gcd;
    }
    private static void displayResults(int num1, int num2, int gcd, int lcm) {
        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("The LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
}
