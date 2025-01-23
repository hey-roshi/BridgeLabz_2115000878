import java.util.Scanner;

public class fizzBuzzwhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        // Check if the number is positive
        if (number > 0) {
            System.out.println("FizzBuzz results:");
            
            int i = 0; // Initialize the counter
            while (i <= number) {
                // Check conditions for Fizz, Buzz, and FizzBuzz
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
                i++; // Increment the counter
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
    }
}
