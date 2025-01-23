     
import java.util.*;
public class oddEven{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check if the entered number is a natural number
        if (number <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            // Start from 1 to the entered number using a for loop
            for (int i = 1; i <= number; i++) {
                // Check if the current number is odd or even
                if (i % 2 == 0) {
                    System.out.println(i + " is even.");
                } else {
                    System.out.println(i + " is odd.");
                }
            }
        }
    }
}
