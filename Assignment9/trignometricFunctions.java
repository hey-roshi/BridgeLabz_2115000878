import java.util.Scanner;
public class trignometricFunctions{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input the angle in degrees
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();
        // Calculate the trigonometric functions
        double[] results = calculateTrigonometricFunctions(angle);
        // Display the results
        System.out.println("For angle " + angle + " degrees:");
        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
    // Method to calculate sine, cosine, and tangent of an angle
    public static double[] calculateTrigonometricFunctions(double angle) {
        // Convert angle from degrees to radians
        double radians = Math.toRadians(angle);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        // Store the results in an array
        return new double[] {sine, cosine, tangent};
    }
}
