import java.util.Scanner;

public class largestSecondlargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for the number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Initial array size to store digits
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits from the number and store them in the digits array
        while (number != 0) {
            if (index == maxDigit) {
                // Increase the array size by 10
                maxDigit += 10;
                int[] temp = new int[maxDigit]; // Create a new temporary array
                System.arraycopy(digits, 0, temp, 0, digits.length); // Copy the old array's contents to the new array
                digits = temp; // Assign the new array to digits
            }
            digits[index++] = number % 10; // Extract the last digit and add it to the array
            number = number / 10; // Remove the last digit from the number
        }

        // Find the largest and second largest digits in the array
        int largest = -1;
        int secondLargest = -1;

        // Loop through the digits array to find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display the largest and second largest digits
        if (largest != -1 && secondLargest != -1) {
            System.out.println("Largest digit: " + largest);
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Not enough digits to determine both largest and second largest.");
        }
    }
}
