import java.util.Scanner;
public class BMI2dArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = sc.nextInt();

        // Create a 2D array to store height, weight, and BMI
        double[][] personData = new double[numPersons][3]; // [0] -> Height, [1] -> Weight, [2] -> BMI
        String[] weightStatus = new String[numPersons];   // Array to store weight status

        // Take input for height and weight
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Enter details for person " + (i + 1) + ":");

            // Input height
            do {
                System.out.print("Enter height (in meters, positive value): ");
                personData[i][0] = sc.nextDouble();
            } while (personData[i][0] <= 0);

            // Input weight
            do {
                System.out.print("Enter weight (in kg, positive value): ");
                personData[i][1] = sc.nextDouble();
            } while (personData[i][1] <= 0);
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numPersons; i++) {
            // BMI = weight / (height^2)
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);

            // Determine weight status based on BMI
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] >= 25 && personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nResults:");
        System.out.println("Person\tHeight (m)\tWeight (kg)\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.println((i + 1) + "\t" 
                    + personData[i][0] + "\t\t" 
                    + personData[i][1] + "\t\t" 
                    + personData[i][2] + "\t" 
                    + weightStatus[i]);
        }
    }
}
