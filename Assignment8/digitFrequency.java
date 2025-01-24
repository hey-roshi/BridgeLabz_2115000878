import java.util.Scanner;

public class digitFrequency{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for the number
        System.out.print("Enter a number: ");
        int number=sc.nextInt();

        // Define a frequency array to store the count of each digit (0-9)
        int[] frequency=new int[10];
        
        // Convert the number to a string to easily loop through each digit
        String numberStr = String.valueOf(number);
        
        // Loop through each digit in the number
        for (int i = 0; i < numberStr.length(); i++) {
            // Extract each digit as a character, then convert it to an integer
            int digit = Character.getNumericValue(numberStr.charAt(i));
            // Increment the frequency count for this digit
            frequency[digit]++;
        }
        
        // Display the frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
    }
}
