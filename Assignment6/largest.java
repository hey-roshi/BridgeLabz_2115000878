import java.util.Scanner;
public class largest{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Prompt the user to enter three numbers
        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = sc.nextInt();
        // Check if each number is the largest
        boolean isFirstNumberLargest = (number1 > number2 && number1 > number3);
        boolean isSecondNumberLargest = (number2 > number1 && number2 > number3);
        boolean isThirdNumberLargest = (number3 > number1 && number3 > number2);

        System.out.println("Is the first number the largest? " + (isFirstNumberLargest ? "Yes" : "No"));
        System.out.println("Is the second number the largest? " + (isSecondNumberLargest ? "Yes" : "No"));
        System.out.println("Is the third number the largest? " + (isThirdNumberLargest ? "Yes" : "No"));
    }
}
