import java.util.Scanner;

public class triangleParkRun {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the sides of the triangular park
        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = scanner.nextDouble();

        // Calculate the number of rounds
        int rounds = calculateRounds(side1, side2, side3);

        // Print the result
        if (rounds == -1) {
            System.out.println("Invalid triangle sides provided.");
        } else {
            System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");
        }
    }

    // Method to calculate the number of rounds required
    public static int calculateRounds(double side1, double side2, double side3) {
        // Check if the sides form a valid triangle using the triangle inequality theorem
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            // Calculate the perimeter of the triangle
            double perimeter = side1 + side2 + side3;

            // Convert 5 km to meters
            double totalDistance = 5000.0;

            // Calculate the number of rounds required
            int rounds = (int) Math.ceil(totalDistance / perimeter); // Use ceil to round up to the nearest whole number

            return rounds;
        } else {
            // Invalid triangle sides
            return -1;
        }
    }
}
